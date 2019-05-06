package cn.xxx.rpms.log;

import cn.xxx.basic.utils.DateUtils;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.basic.utils.SystemServiceLog;
import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.Log;
import cn.xxx.rpms.domain.User;
import cn.xxx.rpms.service.ILogService;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Aspect
@Component
public class SystemLogAspect {
    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);

    private static final ThreadLocal<Date> beginTimeThreadLocal =
            new NamedThreadLocal<Date>("ThreadLocal beginTime");
    private static final ThreadLocal<Log> logThreadLocal =
            new NamedThreadLocal<Log>("ThreadLocal log");

    private static final ThreadLocal<Employee> currentUser=new NamedThreadLocal<>("ThreadLocal employee");

    @Autowired(required=false)
    private HttpServletRequest request;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ILogService logService;

    /**
     * Controller层切点 注解拦截
     */
    @Pointcut("@annotation(cn.xxx.basic.utils.SystemControllerLog)")
    public void controllerAspect(){}
    //Service层切点
    @Pointcut("@annotation(cn.xxx.basic.utils.SystemServiceLog)")
    public  void serviceAspect() {
    }


    /**
     * 前置通知 用于拦截Controller层记录用户的操作的开始时间
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException{
        Date beginTime=new Date();
        beginTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）
        if (logger.isDebugEnabled()){//这里日志级别为debug
            logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                    .format(beginTime), request.getRequestURI());
        }

        //读取session中的用户
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        System.out.println("前值"+session);
        /* User user = (User) session.getAttribute("user_IN_SESSION");*/
        Employee user_in_session = (Employee) session.getAttribute("user_IN_SESSION");
        currentUser.set(user_in_session);

    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     * @param joinPoint 切点
     */
    @SuppressWarnings("unchecked")
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("后置通知？？？？？");
        Employee employee = currentUser.get();
        System.out.println("后置通知"+employee);
        if(employee !=null){
            String title="";
            String type="info";                       //日志类型(info:入库,error:错误)
            String remoteAddr=request.getRemoteAddr();//请求的IP
            String requestUri=request.getRequestURI();//请求的Uri
            String method=request.getMethod();        //请求的方法类型(post/get)
            Map<String,String[]> params=request.getParameterMap(); //请求提交的参数

            try {
                title=getControllerMethodDescription2(joinPoint);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 打印JVM信息。
            long beginTime = beginTimeThreadLocal.get().getTime();//得到线程绑定的局部变量（开始时间）
            long endTime = System.currentTimeMillis();  //2、结束时间
            if (logger.isDebugEnabled()){
                logger.debug("计时结束：{}  URI: {}  耗时： {}   最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime),
                        request.getRequestURI(),
                      /*  DateUtils.formatDateTime(endTime - beginTime)*/
                        Runtime.getRuntime().maxMemory()/1024/1024,
                        Runtime.getRuntime().totalMemory()/1024/1024,
                        Runtime.getRuntime().freeMemory()/1024/1024,
                        (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
            }

            Log log=new Log();
            log.setTitle(title);
            log.setType(type);
            log.setRemoteaddr(remoteAddr);
            log.setRequesturi(requestUri);
            log.setMethod(method);
            log.setUserid(String.valueOf(employee.getId()));
            Date operateDate=beginTimeThreadLocal.get();
            log.setOperatedate(operateDate);
            Long time=endTime - beginTime;
            System.out.println("endTime - beginTime"+time);
            Date date = new Date(endTime);
            log.setTimeout(date);
            System.out.println(log);

            //1.直接执行保存操作
            //this.logService.createSystemLog(log);

            //2.优化:异步保存日志
            //new SaveLogThread(log, logService).start();

            //3.再优化:通过线程池来执行日志保存
          threadPoolTaskExecutor.execute(new SaveLogThread(log, logService));
            logThreadLocal.set(log);
        }

    }

    /**
     *  异常通知 记录操作报错日志
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        Log log = logThreadLocal.get();
        log.setType("error");
        log.setException(e.toString().substring(0, 20));
        /*new UpdateLogThread(log, logService).start();*/
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @param
     * @return discription
     */
    public static String getServiceMthodDescription2(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemServiceLog serviceLog = method
                .getAnnotation(SystemServiceLog.class);
        String discription = serviceLog.description();
        return discription;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return discription
     */
    public static String getControllerMethodDescription2(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemControllerLog controllerLog = method
                .getAnnotation(SystemControllerLog.class);
        String discription = controllerLog.description();
        return discription;
    }

    /**
     * 保存日志线程
     */
  private static class SaveLogThread implements Runnable {
        private Log log;
        private ILogService logService;

        public SaveLogThread(Log log, ILogService logService) {
            this.log = log;
            this.logService = logService;
        }

        @Override
        public void run() {
            logService.add(log);
        }
    }

    /**
     * 日志更新线程
     */
  private static class UpdateLogThread extends Thread {
        private Log log;
        private ILogService logService;

        public UpdateLogThread(Log log, ILogService logService) {
            super(UpdateLogThread.class.getSimpleName());
            this.log = log;
            this.logService = logService;
        }

        @Override
        public void run() {
            this.logService.update(log);
        }
    }
}
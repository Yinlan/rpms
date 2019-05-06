package cn.xxx.test;

import cn.xxx.client.IMantenanceServiceCXF;
import cn.xxx.client.Maintenance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyCilentTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-cxf-client.xml");
        String[] beanDefinitionNames =
                context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    //从spring环境中获取bean，强转
        IMantenanceServiceCXF helloClient = (IMantenanceServiceCXF) context.getBean("helloClient");
        System.out.println(helloClient.getClass());//动态代理
        Maintenance maintenance = (Maintenance) helloClient.get(1L);
        System.out.println(maintenance);//就像调用本地服务一样调用远程服务
    }

}

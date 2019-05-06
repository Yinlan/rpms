package cn.xxx.rpms.shiro;

import cn.xxx.rpms.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 用来存取用户的session的工具
 */
public class UserContext {
    public static final String USER_IN_SESSION="user_IN_SESSION";
    //通过主题拿到session存session
    public static void setUserInSession(Employee employeeInSession){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute(USER_IN_SESSION, employeeInSession);
    }
    //通过主题拿到session里面的用户
    public static Employee getUserInSession(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return (Employee) session.getAttribute(USER_IN_SESSION);
    }
}

package cn.xxx.rpms.web.controller;

import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.service.IUserService;
import cn.xxx.rpms.shiro.UserContext;
import cn.xxx.rpms.web.login.HttpClientUtil;
import cn.xxx.rpms.web.login.WeChatConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/main")
    private String main(){
        return "main";
    }
    //解决登陆同请求的不同请求方式的问题
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String getLogin(){
        return "login/login";
    }

    /**
     *
     * @param username
     * @param password
     * @return
     * 前台传来用户名和密码---->存入令牌---->通过主题登录---->shiro进行加密加盐
     * ---->自定义realm 登录判断 ---->查询数据库---->存入shiro 判断---->判断成功存入session
     * ---->角色和授权
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @SystemControllerLog(description = "登录")
    public String login(String username, String password,HttpServletRequest request){
   /*     //前台传来的验证码
        String rondomcode = request.getParameter("rondomcode");
        //对验证码进行校验
        if(rondomcode==null||"".equals(rondomcode)){
            return new JsonResult(false,"验证码不能为空");
        }
        if(!rondomcode.equals((String) request.getSession().getAttribute("randomcode_IN_SESSION"))){
            return new JsonResult(false,"验证码错误");
        }*/

        //拿到用户
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
        }
        catch (UnknownAccountException e) {
            e.printStackTrace();
                new JsonResult(false,"用户名错误");
            return "login/login";
        }
        catch (IncorrectCredentialsException e) {
            e.printStackTrace();
             new JsonResult(false,"用户或密码错误");
            return "login/login";
        }
        catch (AuthenticationException e) {
            e.printStackTrace();
             new JsonResult(false,"未知错误");
            return "login/login";
        }
        //登录成功存入用户到session
        Employee employee = (Employee) subject.getPrincipal();
        UserContext.setUserInSession(employee);
        return "main";
    }
    //注销
    @RequestMapping("/logout")
    @SystemControllerLog(description = "退出系统")
    public String regist(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login/login";
    }
    @RequestMapping("/wechat")
    @SystemControllerLog(description = "微信登录")
    public String wechat(){

        return "login/wechat";
    }
    @RequestMapping("/callback")
    public String callback(String code, String state, Model model, HttpServletRequest req){

        String atUrl =  WeChatConstants.ACCESSTOKEURL.replace("APPID", WeChatConstants.APPID)
                .replace("SECRET",WeChatConstants.APPSECRET)
                .replace("CODE",code);
        String atJsonStr = HttpClientUtil.doGet(atUrl);
        System.out.println("atJsonStr:"+atJsonStr);
        JSONObject jsonObject = (JSONObject) JSON.parse(atJsonStr);
        String access_token = String.valueOf(jsonObject.get("access_token"));
        String open_id = String.valueOf(jsonObject.get("openid"));
        System.out.println("access_token:"+access_token);
        System.out.println("open_id:"+open_id);

        String userInfoUrl = WeChatConstants.USERINFOURL.replace("ACCESS_TOKEN", access_token).replace("OPENID", open_id);
        String userInfo = HttpClientUtil.doGet(userInfoUrl);

        JSONObject userJson = (JSONObject)JSON.parse(userInfo);
        System.out.println(userJson);
        //完成绑定操作
        model.addAttribute("userInfo", userInfo);
        Employee user = userService.getUser(open_id);
        if(user==null){
            return "login";
        }
        System.out.println(user);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getName());
        subject.login(usernamePasswordToken);
            return "main";

    }


}

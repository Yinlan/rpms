package cn.xxx.rpms.shiro;

import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.domain.Role;
import cn.xxx.rpms.service.IEmployeeService;
import cn.xxx.rpms.service.IPermissionService;
import cn.xxx.rpms.service.IRoleService;
import cn.xxx.rpms.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeChatRealm  extends AuthorizingRealm {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IUserService userService;
    /**
     * 授权方法：（登录成功进入）
     * 拿到授权的用户名---根据用户名授权
     * @param principals
     * @return
     */
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IRoleService roleService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //拿到用户名

        Employee employee = (Employee) principals.getPrimaryPrincipal();

//        //根据用户名拿到角色与授权----需要遍历出来给set赋值
//        Set<String> rolesByUsername =getRolesByUsername(employee);

        //通过用户id拿到权限sn----需要自己jpql关联查询到权限的sn
        List<Role> roles = employeeService.selectManyRoleByID(employee.getId());

        Set<String> permissionsSN=  new HashSet<>();
        for(Role role:roles){
            Role role1 = roleService.selectManyToPermissionByID(role.getId());
            List<Permission> permissions = role1.getPermissions();
            for(Permission permission:permissions){
                permissionsSN.add(permission.getResource());
            }

        }
        //Set<String> permissionsSN = permissionService.findSnByJPQL(employee.getId());

        //设置角色与授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles(rolesByUsername);
        simpleAuthorizationInfo.setStringPermissions(permissionsSN);
        return simpleAuthorizationInfo;
    }
    //模拟根据用户名拿到角色的功能
    private Set<String> getRolesByUsername(Employee employee) {
        //返回给shiro的权限集合
        Set<String> roles = new HashSet<>();

        //通过用户拿到的当前角色
        List<Role> roleByID = employeeService.selectManyRoleByID(employee.getId());
        Set<Role> roles1 = new HashSet<>();
        for(Role role:roleByID){
            roles1.add(role);
        }
        roles1.forEach(e->{
            roles.add(e.getName());
        });

        return roles;
    }


    /**
     *
     * @param token 令牌 通过令牌拿到主题---将令牌存入session（抽取工具类）
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //拿到令牌
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;

        //通过session拿到主体
        String username = token1.getUsername();
        //拿着用户名取数据库 取密码

        Employee employee = employeeService.findEmployeeByUsername(username);
        //如果为空直接返回null securitymanager会自动抛出用户名为空异常
        if(employee==null){
            return null;
        }
        //存session
        UserContext.setUserInSession(employee);

        //加盐
        ByteSource sate = ByteSource.Util.bytes(MD5Util.SALT);
        //用户名不为空 直接返回身份验证信息对象 传入令牌的名字 查询到的密码 和连接名
        //它会自动根据你的令牌的密码与查询到的密码作比较 如果不匹配会抛出不正确的身份凭证密码
        //设置加密盐值
        AuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(employee,employee.getPwd(),sate,"连接名");
        return simpleAuthenticationInfo;
    }

}

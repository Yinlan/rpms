package cn.xxx.rpms.shiro;


import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*<!-- 设置权限和资源
       annon不需要权限和登录也可以访问的页面
       authc需要登录才能访问
       perms[]
       -->*/
public class filterChainDefinitionMapFactory {
   @Autowired
   private IPermissionService permissionService;
   public Map<String,String> createfilterChainDefinitionMap(){
     Map<String, String> map = new LinkedHashMap<>();
    /*     map.put("/static/**","anon");
       map.put("/login", "anon");
       map.put("/upload/**", "anon");
       map.put("/wechat", "anon");
       map.put("/callback", "anon");
       map.put("/util/**", "anon");
       map.put("/WEB-INF/views/login.jsp", "anon");
       //通过读取数据库读取信息
         List<Permission> permissions = permissionService.getAll();
       permissions.forEach(e->{
           map.put(e.getUrl(),  "ajaxFilter["+e.getResource()+"]");
       });*/
      /*map.put("/**", "authc");*/
       map.put("/**", "anon");
       return map;
   }
}

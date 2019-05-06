package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.LayUiPageList;
import cn.xxx.rpms.domain.*;
import cn.xxx.rpms.service.*;
import cn.xxx.rpms.shiro.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/util")
public class UtilController {
    @Autowired
    private IOptService optService;
    @Autowired
    private IPartsService partsService;
    @Autowired
    private IPayTypeService payTypeService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IRoleService roleService;
    @RequestMapping("/opt")
    @ResponseBody
    public List<Opt> getOptList(){
        return optService.getAll();
    }
    @RequestMapping("/parts")
    @ResponseBody
    public List<Parts> getPartList(){
        return partsService.getAll();
    }
    @RequestMapping("/paytype")
    @ResponseBody
    public List<PayType> gePayTypeList(){
        return payTypeService.getAll();
    }
    @RequestMapping("/map")
    public String map(String address,HttpServletRequest httpServletRequest){

        httpServletRequest.getSession().setAttribute("address", address);
        System.out.println(address);
        return "/mantenanceCar/map";
    }
    @RequestMapping("/parent")
    @ResponseBody
    public List<Menu> menuList(){
        return menuService.selectParent();
    }
    @RequestMapping("/permission")
    @ResponseBody
    public LayUiPageList<Permission> permissionList(BaseQuery baseQuery){
        LayUiPageList<Permission> permissionLayUiPageList=new LayUiPageList<>();
        permissionLayUiPageList.setCount(permissionService.selectMany(baseQuery).getTotal());
        permissionLayUiPageList.setData(permissionService.selectMany(baseQuery).getRows());
        return permissionLayUiPageList;
    }
    @RequestMapping("/role")
    @ResponseBody
    public List<Role> roleList(){
        return roleService.getAll();
    }
    @RequestMapping("/menu")
    @ResponseBody
    public List<MenuTree> menuList2(BaseQuery query){
        Employee userInSession = UserContext.getUserInSession();
        List<Menu> rows = menuService.selectSelfMenu(userInSession.getId());
        List<MenuTree> menuTreeList=new ArrayList<>();
        for (Menu menu:rows){
            MenuTree menuTree = new MenuTree();
            menuTree.setId(menu.getId());
            menuTree.setName(menu.getName());
            List<Menu> menuChildren = menu.getChildren();
            List<MenuTree> menuTreeListChilren=new ArrayList<>();
            for (Menu menuChilren:menuChildren){


                MenuTree menuTreeChilren = new MenuTree();
                menuTreeChilren.setId(menuChilren.getId());
                menuTreeChilren.setName(menuChilren.getName());
                menuTreeChilren.setUrl(menuChilren.getUrl());
                menuTreeListChilren.add(menuTreeChilren);
            }
            menuTree.setChildren(menuTreeListChilren);
            menuTreeList.add(menuTree);

        }
        return menuTreeList;
    }
}

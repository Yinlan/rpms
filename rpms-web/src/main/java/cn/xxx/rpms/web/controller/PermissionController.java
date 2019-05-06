package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.PayType;
import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.service.IPayTypeService;
import cn.xxx.rpms.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("/index")
    private String getPermissionList(){
        return "/system/permission";
    }
    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "权限查询")
    public PageList<Permission> permissionList(BaseQuery partsQuery){
        return permissionService.selectMany(partsQuery);
    }

    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "权限保存")
    public JsonResult save(Permission permission){
        JsonResult jsonResult = new JsonResult();
        try {
            if(permission.getId()==null||"".equals(permission.getId())){

                permissionService.add(permission);
            }else{
                permissionService.update(permission);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "权限删除")
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                permissionService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
}

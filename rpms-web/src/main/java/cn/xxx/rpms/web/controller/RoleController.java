package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.domain.Role;
import cn.xxx.rpms.service.IPayTypeService;
import cn.xxx.rpms.service.IPermissionService;
import cn.xxx.rpms.service.IRoleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @Autowired
    @RequestMapping("/index")
    private String getPartList(){
        return "/system/role";
    }
    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "角色查询")
    public PageList<Role> maintenancePageList(BaseQuery roleQuery){
        return roleService.selectManyToPermission(roleQuery);
    }

    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "角色保存")
    public JsonResult save(String  str,Long[] permissionList){
        JsonResult jsonResult = new JsonResult();

        //将得到的权限存入
        JSONObject jsonObject=JSONObject.parseObject(str);
        Role role=(Role)JSONObject.toJavaObject(jsonObject, Role.class);
          try {
            if(role.getId()==null||"".equals(role.getId())){

                roleService.add(role,permissionList);
            }else{
                roleService.update(role,permissionList);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "角色删除")
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                roleService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
}

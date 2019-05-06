package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.service.IEmployeeService;
import cn.xxx.rpms.service.IPayTypeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @RequestMapping("/index")
    private String getPartList(){
        return "/system/employee";
    }
    @RequestMapping("/page")
    @SystemControllerLog(description = "查询员工")
    @ResponseBody
    public PageList<Employee> maintenancePageList(BaseQuery partsQuery){
        return employeeService.queryPage(partsQuery);
    }

    @RequestMapping("/save")
    @SystemControllerLog(description = "保存员工")
    @ResponseBody
    public JsonResult save(String str,Long rid){
        JsonResult jsonResult = new JsonResult();
        //将得到的权限存入
        JSONObject jsonObject=JSONObject.parseObject(str);
        Employee employee=(Employee) JSONObject.toJavaObject(jsonObject, Employee.class);
        try {
      if(employee.getId()==null||"".equals(employee.getId())){

                employeeService.add(employee,rid);
            }else{
                employeeService.update(employee,rid);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @SystemControllerLog(description = "删除用户")
    @ResponseBody
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                employeeService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
}

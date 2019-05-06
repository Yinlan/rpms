package cn.xxx.rpms.web.controller;


import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.query.MaintenanceQuery;
import cn.xxx.rpms.service.IMantenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/repair")
public class MantenanceController {
    @Autowired
    private IMantenanceService mantenanceService;
    @RequestMapping("/index")
    public String index(){
        return "/mantenance/mantenance";
    }


    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "查询维修单")
    public PageList<Maintenance> maintenancePageList(BaseQuery maintenanceBaseQuery){
        return mantenanceService.queryPage(maintenanceBaseQuery);
    }
    @RequestMapping("/carindex")
    @SystemControllerLog(description = "还车管理")
    public String maintenancePageListForCar(BaseQuery maintenanceBaseQuery){
        return "/mantenanceCar/mantenanceCar";
    }
    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "保存维修单")
    public JsonResult save(Maintenance maintenance){
        JsonResult jsonResult = new JsonResult();
        try {
            if(maintenance.getMainid()==null||"".equals(maintenance.getMainid())){

                mantenanceService.add(maintenance);
            }else{
                mantenanceService.update(maintenance);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "删除维修单")
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                mantenanceService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/search")
    @ResponseBody
    @SystemControllerLog(description = "车牌号查询")
    public PageList<Maintenance> maintenanceQueryPageList(MaintenanceQuery maintenanceBaseQuery){
        PageList<Maintenance> maintenancePageList = mantenanceService.queryLimt(maintenanceBaseQuery);
        return mantenanceService.queryLimt(maintenanceBaseQuery);
    }
}

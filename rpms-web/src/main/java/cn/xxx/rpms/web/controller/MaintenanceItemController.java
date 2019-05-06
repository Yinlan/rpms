package cn.xxx.rpms.web.controller;


import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.MaintenanceItem;
import cn.xxx.rpms.mapper.MaintenanceItemMapper;
import cn.xxx.rpms.query.MaintenanceItemQuery;
import cn.xxx.rpms.service.IMaintenanceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/repairItem")
public class MaintenanceItemController {
    @Autowired
    private IMaintenanceItemService maintenanceItemService;
    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "查询维修明细单")
    public PageList<MaintenanceItem> maintenanceItemPageList(MaintenanceItemQuery maintenanceBaseQuery){
        return maintenanceItemService.queryPage(maintenanceBaseQuery);
    }
    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "保存维修明细单")
    public JsonResult save(MaintenanceItem maintenanceItem){
        System.out.println(maintenanceItem);
        JsonResult jsonResult = new JsonResult();
        try {
            if(maintenanceItem.getItemid()==null||"".equals(maintenanceItem.getItemid())){

                maintenanceItemService.addItem(maintenanceItem);
            }else{
                maintenanceItemService.updateItem(maintenanceItem);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "删除维修明细单")
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                maintenanceItemService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
}

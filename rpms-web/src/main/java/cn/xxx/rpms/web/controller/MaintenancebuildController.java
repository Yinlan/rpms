package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.MaintenanceItem;
import cn.xxx.rpms.domain.Maintenancebuild;
import cn.xxx.rpms.mapper.MaintenancebuildMapper;
import cn.xxx.rpms.query.MaintenanceBuildQuery;
import cn.xxx.rpms.query.MaintenanceQuery;
import cn.xxx.rpms.service.IMaintenancebuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/build")
public class MaintenancebuildController {
    @Autowired
    private IMaintenancebuildService maintenancebuildService;
    @RequestMapping("/index")
    public String index(){
        return "/maintenanceBuild/maintenanceBuild";
    }

    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "查询结算单")
    public PageList<Maintenancebuild> maintenancePageList(BaseQuery maintenanceBaseQuery){
        return maintenancebuildService.queryPage(maintenanceBaseQuery);
    }
    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "保存结算单")
    public JsonResult save(Maintenancebuild maintenancebuild){
        System.out.println(maintenancebuild);
        JsonResult jsonResult = new JsonResult();
        try {
            if(maintenancebuild.getSid()==null||"".equals(maintenancebuild.getSid())){

                maintenancebuildService.add(maintenancebuild);
            }else{
                maintenancebuildService.update(maintenancebuild);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "删除结算单")
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                maintenancebuildService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/search")
    @ResponseBody
    @SystemControllerLog(description = "查询结算单")
    public PageList<Maintenancebuild> maintenanceQueryPageList(MaintenanceBuildQuery maintenanceBuildQuery){
        return  maintenancebuildService.queryLimt(maintenanceBuildQuery);
    }
}

package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Opt;
import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.query.OptQuery;
import cn.xxx.rpms.query.PartsQuery;
import cn.xxx.rpms.service.IOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/opt")
public class OptController {
    @Autowired
    private IOptService optService;
    @RequestMapping("/index")
    @SystemControllerLog(description = "查询维修人员")
    private String getPartList(){
        return "/system/opt";
    }
    @RequestMapping("/page")
    @ResponseBody
    public PageList<Opt> maintenancePageList(BaseQuery partsQuery){
        return optService.queryPage(partsQuery);
    }

    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "保存维修人员")
    public JsonResult save(Opt opt){
        JsonResult jsonResult = new JsonResult();
        try {
            if(opt.getOptid()==null||"".equals(opt.getOptid())){

                optService.add(opt);
            }else{
                optService.update(opt);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "删除维修人员")
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                optService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/search")
    @ResponseBody
    @SystemControllerLog(description = "维修人员条件查询")
    public PageList<Opt> maintenanceQueryPageList(OptQuery optQuery)  {
        System.out.println(optQuery);
        try {
            return optService.loadDataByQueryLimt(optQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

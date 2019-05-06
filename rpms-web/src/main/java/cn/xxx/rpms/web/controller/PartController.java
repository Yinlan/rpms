package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.LuceneUtil;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.query.MaintenanceQuery;
import cn.xxx.rpms.query.PartsQuery;
import cn.xxx.rpms.service.IPartsService;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/car")
public class PartController {
    @Autowired
    private IPartsService partsService;

    @RequestMapping("/index")
    private String getPartList(){
        return "/parts/parts";
    }
    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "配件查询")
    public PageList<Parts> maintenancePageList(BaseQuery partsQuery){
        return partsService.queryPage(partsQuery);
    }
    @RequestMapping("/checkName")
    @ResponseBody
    @SystemControllerLog(description = "配件重名检查")
    public Boolean checkName(PartsQuery partsQuery){
        System.out.println(partsQuery.getPid());

        return partsService.checkNameQuery(partsQuery);
    }
    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "配件保存")
    public JsonResult save(Parts parts){
        JsonResult jsonResult = new JsonResult();
        try {
            if(parts.getPid()==null||"".equals(parts.getPid())){

                partsService.add(parts);
            }else{
                partsService.update(parts);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "还车删除")
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                partsService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/updateDb")
    @ResponseBody
    public PageList<Parts> updateDb() throws IOException {
        System.out.println("成功了");
//            LuceneUtil.deleteAllIndex();
            partsService.updateIndex();
        PartsQuery partsQuery = new PartsQuery();
        return partsService.queryPage(partsQuery);
    }
    @RequestMapping("/search")
    @ResponseBody
    public PageList<Parts> maintenanceQueryPageList(PartsQuery partsQuery) throws Exception {
      /*  PageList<Maintenance> maintenancePageList = mantenanceService.queryLimt(maintenanceBaseQuery);
        return mantenanceService.queryLimt(maintenanceBaseQuery);*/

                return partsService.getByQuery(partsQuery);

    }
}

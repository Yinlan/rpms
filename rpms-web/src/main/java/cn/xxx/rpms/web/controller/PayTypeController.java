package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.domain.PayType;
import cn.xxx.rpms.query.PartsQuery;
import cn.xxx.rpms.service.IPartsService;
import cn.xxx.rpms.service.IPayTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pay")
public class PayTypeController {
    @Autowired
    private IPayTypeService payTypeService;
    @RequestMapping("/index")
    private String getPartList(){
        return "/system/payType";
    }
    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "支付方式查询")
    public PageList<PayType> maintenancePageList(BaseQuery partsQuery){
        return payTypeService.queryPage(partsQuery);
    }

    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "支付方式保存")
    public JsonResult save(PayType parts){
        JsonResult jsonResult = new JsonResult();
        try {
            if(parts.getPayid()==null||"".equals(parts.getPayid())){

                payTypeService.add(parts);
            }else{
                payTypeService.update(parts);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "支付方式删除")
    public JsonResult delete(Long[] ids){
        System.out.println(ids);
        JsonResult jsonResult = new JsonResult();
        try {
            for(Long id:ids){
                payTypeService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
}

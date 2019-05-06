package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.PayType;
import cn.xxx.rpms.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/login")
@Controller
public class LogController {
    @Autowired
    private ILogService logService;
    @RequestMapping("/index")
    private String getPartList(){
        return "/system/log";
    }
    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "支付方式查询")
    public PageList<PayType> maintenancePageList(BaseQuery logQuery){
        return logService.queryPage(logQuery);
    }
}

package cn.xxx.rpms.service;

import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.query.MaintenanceQuery;

import javax.jws.WebService;

@WebService
public interface IMantenanceServiceCXF extends IBaseService<Maintenance>{
    PageList<Maintenance> queryLimt(MaintenanceQuery maintenanceQuery);
}

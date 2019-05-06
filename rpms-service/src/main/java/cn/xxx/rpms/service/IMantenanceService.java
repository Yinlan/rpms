package cn.xxx.rpms.service;

import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.query.MaintenanceQuery;

import java.util.List;

public interface IMantenanceService extends IBaseService<Maintenance>{
    PageList<Maintenance> queryLimt(MaintenanceQuery maintenanceQuery);
}

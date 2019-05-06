package cn.xxx.rpms.service;

import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.Maintenancebuild;
import cn.xxx.rpms.query.MaintenanceBuildQuery;
import cn.xxx.rpms.query.MaintenanceQuery;

public interface IMaintenancebuildService extends IBaseService<Maintenancebuild> {
    PageList<Maintenancebuild> queryLimt(MaintenanceBuildQuery maintenanceBuildQuery);
}

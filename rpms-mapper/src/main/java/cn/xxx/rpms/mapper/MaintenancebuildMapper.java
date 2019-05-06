package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.Maintenancebuild;
import cn.xxx.rpms.query.MaintenanceBuildQuery;
import cn.xxx.rpms.query.MaintenanceQuery;

import java.util.List;

public interface MaintenancebuildMapper extends BaseMapper<Maintenancebuild> {
    List<Maintenancebuild> loadDataByQueryLimt(MaintenanceBuildQuery maintenanceBuildQuery);

}
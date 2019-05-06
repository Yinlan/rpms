package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.query.MaintenanceQuery;

import java.util.List;

public interface MaintenanceMapper extends BaseMapper<Maintenance> {
    List<Maintenance> loadDataByQueryLimt(MaintenanceQuery maintenanceQuery);
}
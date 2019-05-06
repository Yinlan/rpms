package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.Opt;
import cn.xxx.rpms.query.MaintenanceQuery;
import cn.xxx.rpms.query.OptQuery;

import java.util.List;

public interface OptMapper extends BaseMapper<Opt> {
    List<Opt> loadDataByQueryLimt(OptQuery optQuery);
}
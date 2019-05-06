package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.query.PartsQuery;

import java.util.List;

public interface PartsMapper extends BaseMapper<Parts> {
    Parts checkNameQuery(PartsQuery partsQuery);
}
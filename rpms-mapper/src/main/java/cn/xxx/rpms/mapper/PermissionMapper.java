package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.rpms.domain.Permission;
import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
     List<Permission> selectManyRole(BaseQuery baseQuery);
     Permission selectManyRoleByID(Long id);
}
package cn.xxx.rpms.service;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Permission;

import java.util.List;

public interface IPermissionService extends IBaseService<Permission> {
    PageList<Permission> selectManyRole(BaseQuery baseQuery);
    Permission selectManyRoleByID(Long id);
    PageList<Permission> selectMany(BaseQuery baseQuery);
}

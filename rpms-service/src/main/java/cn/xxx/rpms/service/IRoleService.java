package cn.xxx.rpms.service;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Role;

public interface IRoleService extends IBaseService<Role>{
    PageList<Role> selectManyToPermission(BaseQuery baseQuery);
    PageList<Role> selectManyToEmployee(BaseQuery baseQuery);
    void add(Role role, Long[] pid);
    void update(Role role, Long[] pid);
    Role selectManyToPermissionByID(Long id);

}

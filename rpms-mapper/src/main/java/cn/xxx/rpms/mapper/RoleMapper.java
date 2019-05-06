package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.domain.Role;
import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    //查询所有角色对应的权限
    List<Role> selectManyToPermission(BaseQuery baseQuery);

     Role selectManyToPermissionByID(Long id);


    //查询所有角色对应的员工
    List<Role> selectManyToEmployee(BaseQuery baseQuery);

    Role selectManyToEmployeeByID(Long id);

    int insertGetId(Role role);


}
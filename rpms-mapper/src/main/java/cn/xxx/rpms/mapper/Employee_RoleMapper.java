package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.rpms.domain.Employee_Role;
import cn.xxx.rpms.domain.Role_Permission;

import java.util.List;

public interface Employee_RoleMapper extends BaseMapper<Employee_Role>{

    Employee_Role selectIdByEidAndRid(Employee_Role record);
    void  deleteByEidAndRid(Employee_Role record);
}
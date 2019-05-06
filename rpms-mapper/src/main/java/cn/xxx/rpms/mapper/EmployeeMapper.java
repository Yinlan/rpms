package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.rpms.domain.Employee;
import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
    //从员工查询 角色
    List<Employee> selectManyRole(BaseQuery baseQuery);
    //从员工查询 角色 单挑查询
    Employee selectManyRoleByID(Long id);
    Employee selectByUserName(String username);

}
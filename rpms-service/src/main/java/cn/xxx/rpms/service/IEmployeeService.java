package cn.xxx.rpms.service;

import cn.xxx.basic.service.IBaseService;
import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.Role;

import java.util.List;

public interface IEmployeeService extends IBaseService<Employee>{
    void add(Employee employee, Long eid);
    void update(Employee employee, Long eid);
    List<Role> selectManyRoleByID(Long eid);
    Employee findEmployeeByUsername(String username);
}

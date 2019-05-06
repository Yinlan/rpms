package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.Employee_Role;
import cn.xxx.rpms.domain.Role;
import cn.xxx.rpms.domain.Role_Permission;
import cn.xxx.rpms.mapper.EmployeeMapper;
import cn.xxx.rpms.mapper.Employee_RoleMapper;
import cn.xxx.rpms.service.IEmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private Employee_RoleMapper employee_roleMapper;

    @Override
    protected BaseMapper<Employee> getMapper() {
        return employeeMapper;
    }
    @Override
    public PageList<Employee> queryPage(BaseQuery query) {
        Page<Employee> objects = PageHelper.startPage(query.getPage(), query.getLimit());
        //拿到分页后的总数据
        employeeMapper.selectManyRole(query);
        return new PageList<>(objects.getTotal(), objects.getResult());
    }

    @Override
    public void add(Employee employee, Long rid) {
        employeeMapper.insert(employee);
        Long eId = employee.getId();
        //存入关系
        Employee_Role employee_role = new Employee_Role();
        employee_role.setRoleId(rid);
        employee_role.setEmployeeId(eId);
        employee_roleMapper.insert(employee_role);

    }

    @Override
    public void update(Employee employee, Long rid) {
        List<Role> employeeRoles = employee.getRoles();
        Long employeeId = employee.getId();
        for (Role role:employeeRoles){
            Long roleId = role.getId();
            Employee_Role employee_role = new Employee_Role();
            employee_role.setEmployeeId(employeeId);
            employee_role.setRoleId(roleId);
            employee_roleMapper.deleteByEidAndRid(employee_role);
        }

        employeeMapper.updateByPrimaryKey(employee);
        Long employeeId1 = employee.getId();
        Employee_Role employee_role = new Employee_Role();
        employee_role.setRoleId(rid);
        employee_role.setEmployeeId(employeeId1);
        employee_roleMapper.insert(employee_role);

    }

    @Override
    public List<Role> selectManyRoleByID(Long eid) {
        return  employeeMapper.selectManyRoleByID(eid).getRoles();
    }

    @Override
    public Employee findEmployeeByUsername(String username) {
        return employeeMapper.selectByUserName(username);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeMapper.selectManyRoleByID(id);
        List<Role> employeeRoles = employee.getRoles();
        for (Role role:employeeRoles){
            Long rid = role.getId();
            Employee_Role employee_role = new Employee_Role();
            employee_role.setEmployeeId(id);
            employee_role.setRoleId(rid);
            employee_roleMapper.deleteByEidAndRid(employee_role);
        }
        employeeMapper.deleteByPrimaryKey(id);
    }
}

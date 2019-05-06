package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.rpms.domain.Menu_Employee;
import java.util.List;

public interface Menu_EmployeeMapper extends BaseMapper<Menu_Employee>{
    List<Menu_Employee> selectByEid(Long id);
}
package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.User;
import cn.xxx.rpms.mapper.EmployeeMapper;
import cn.xxx.rpms.mapper.UserMapper;
import cn.xxx.rpms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public Employee getUser(String opid) {
        User user = userMapper.selectByOpenid(opid);
        if(user==null){
            return null;
        }
        return employeeMapper.selectManyRoleByID(user.getEid());
    }
}

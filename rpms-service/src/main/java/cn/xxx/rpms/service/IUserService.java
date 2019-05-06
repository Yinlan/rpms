package cn.xxx.rpms.service;

import cn.xxx.basic.service.IBaseService;
import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.User;

public interface IUserService extends IBaseService<User>  {
    Employee getUser(String opid);
}

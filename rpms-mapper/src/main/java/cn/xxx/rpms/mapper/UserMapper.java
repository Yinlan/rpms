package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.rpms.domain.User;
import java.util.List;

public interface UserMapper extends BaseMapper<User>{
    User selectByOpenid(String openid);
}
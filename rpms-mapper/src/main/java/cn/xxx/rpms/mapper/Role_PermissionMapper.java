package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.rpms.domain.Role_Permission;
import java.util.List;

public interface Role_PermissionMapper extends BaseMapper<Role_Permission>{


    Role_Permission selectIdByRidAndPID(Role_Permission record);
    void deleteByPidAndRid(Role_Permission record);


}
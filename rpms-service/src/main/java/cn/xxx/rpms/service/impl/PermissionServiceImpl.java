package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.mapper.PermissionMapper;
import cn.xxx.rpms.service.IPermissionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    protected BaseMapper<Permission> getMapper() {
        return permissionMapper;
    }

    @Override
    public PageList<Permission> selectManyRole(BaseQuery baseQuery) {
        Page<Permission> objects = PageHelper.startPage(baseQuery.getPage(), baseQuery.getLimit());
        //拿到分页后的总数据
        permissionMapper.selectManyRole(baseQuery);
        return new PageList<>(objects.getTotal(), objects.getResult());
    }

    @Override
    public Permission selectManyRoleByID(Long id) {
        return null;
    }

    @Override
    public PageList<Permission> selectMany(BaseQuery baseQuery) {
        Page<Permission> objects = PageHelper.startPage(baseQuery.getPage(), baseQuery.getLimit());
        //拿到分页后的总数据
        permissionMapper.loadDataByQuery(baseQuery);
        return new PageList<>(objects.getTotal(), objects.getResult());
    }
}

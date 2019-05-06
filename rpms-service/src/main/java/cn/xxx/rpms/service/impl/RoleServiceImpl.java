package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.domain.Role;
import cn.xxx.rpms.domain.Role_Permission;
import cn.xxx.rpms.mapper.PermissionMapper;
import cn.xxx.rpms.mapper.RoleMapper;
import cn.xxx.rpms.mapper.Role_PermissionMapper;
import cn.xxx.rpms.service.IRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private Role_PermissionMapper role_permissionMapper;

    @Override
    protected BaseMapper<Role> getMapper() {
        return roleMapper;
    }


    @Override
    public PageList<Role> selectManyToPermission(BaseQuery baseQuery) {
        //Page<Role> objects = PageHelper.startPage(baseQuery.getPage(), baseQuery.getLimit());
        //拿到分页后的总数据
        List<Role> roles = roleMapper.selectManyToPermission(baseQuery);
        return new PageList<>(Long.valueOf(roles.size()),roles);
    }

    @Override
    public PageList<Role> selectManyToEmployee(BaseQuery baseQuery) {
        Page<Role> objects = PageHelper.startPage(baseQuery.getPage(), baseQuery.getLimit());

        //拿到分页后的总数据
        roleMapper.selectManyToEmployee(baseQuery);

        return new PageList<>(objects.getTotal(), objects.getResult());
    }
    @Override
    public void add(Role role,Long[] pid) {

        //一个角色对应多个权限
        roleMapper.insertGetId(role);
        //关系存入中间表
        Long roleId = role.getId();
        System.out.println(roleId);
        for(Long permissonId:pid){
            //拿到一个权限 存入list
            Permission permission = permissionMapper.selectByPrimaryKey(permissonId);
            Role_Permission role_permission = new Role_Permission();
            role_permission.setRoleId(roleId);
            role_permission.setPermissionId(permissonId);
            role_permissionMapper.insert(role_permission);
        }
    }
    @Override
    public void update(Role role,Long[] pid) {
        Long roleId = role.getId();
        //先将原来的权限进行清空
        Role role1 = roleMapper.selectManyToPermissionByID(roleId);
        List<Permission> permissions = role1.getPermissions();
        for (Permission per:permissions){
                Long id = per.getId();
                Role_Permission role_permission = new Role_Permission();
                role_permission.setRoleId(roleId);
                role_permission.setPermissionId(id);
                role_permissionMapper.deleteByPidAndRid(role_permission);
            }
        roleMapper.updateByPrimaryKey(role);
        //关系存入中间表
        for(Long permissonId:pid){
            //拿到一个权限 存入list
            Permission permission = permissionMapper.selectByPrimaryKey(permissonId);
            Role_Permission role_permission = new Role_Permission();
            role_permission.setRoleId(roleId);
            role_permission.setPermissionId(permissonId);
            role_permissionMapper.insert(role_permission);
        }

    }

    @Override
    public Role selectManyToPermissionByID(Long id) {
        return roleMapper.selectManyToPermissionByID(id);
    }

    @Override
    public void delete(Long id) {
        Role role = roleMapper.selectManyToPermissionByID(id);

        List<Permission> permissions = role.getPermissions();
        System.out.println(permissions);
            for (Permission per:permissions){
                Long pid = per.getId();
                Role_Permission role_permission = new Role_Permission();
                role_permission.setRoleId(id);
                role_permission.setPermissionId(pid);
                role_permissionMapper.deleteByPidAndRid(role_permission);
            }
        roleMapper.deleteByPrimaryKey(id);
    }


}

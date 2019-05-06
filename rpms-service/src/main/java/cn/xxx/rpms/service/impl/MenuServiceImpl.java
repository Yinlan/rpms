package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Menu;
import cn.xxx.rpms.domain.Menu_Employee;
import cn.xxx.rpms.mapper.MenuMapper;
import cn.xxx.rpms.mapper.Menu_EmployeeMapper;
import cn.xxx.rpms.service.IMenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private Menu_EmployeeMapper menu_employeeMapper;
    @Override
    protected BaseMapper<Menu> getMapper() {
        return menuMapper;
    }
    @Override
    public PageList<Menu> queryPageBySelf(BaseQuery query) {
        Page<Menu> objects = PageHelper.startPage(query.getPage(), query.getLimit());
        //拿到分页后的总数据
        menuMapper.selectSelf(query);
        return new PageList<>(objects.getTotal(), objects.getResult());
    }

    @Override
    public List<Menu> selectParent() {
        return menuMapper.selectParent();
    }

    @Override
    public void add(Menu menu) {

        menuMapper.insert(menu);
    }
    @Override
    public void delete(Long id) {
        Menu menu = menuMapper.selectByPrimaryKey(id);
        //判断是否是父菜单

        //子菜单
        if(menu.getParent()==null) {
            menuMapper.deletChildrenByParent(id);
        }
        //父菜单
        menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Menu> selectSelfMenu(Long eid) {
        List<Menu> resulList=new ArrayList<>();
        List<Menu_Employee> menu_employees = menu_employeeMapper.selectByEid(eid);
        for(Menu_Employee menu_employee:menu_employees){
            List<Menu> menus = menuMapper.selectSelfById(menu_employee.getMid());
            for(Menu menu:menus){
                resulList.add(menu);
            }
        }
        return resulList;
    }
}

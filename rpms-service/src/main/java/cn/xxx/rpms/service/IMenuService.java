package cn.xxx.rpms.service;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Menu;

import java.util.List;

public interface IMenuService extends IBaseService<Menu> {
    PageList<Menu>  queryPageBySelf(BaseQuery query);

    List<Menu> selectParent();

    void delete(Long id);

    List<Menu> selectSelfMenu(Long eid);
}

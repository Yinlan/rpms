package cn.xxx.rpms.mapper;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.Menu;
import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    //自连接查询
    List<Menu> selectSelf(BaseQuery query);

    List<Menu> selectParent();

    void deletChildrenByParent(Long id);
    List<Menu> selectSelfNoQuery();

    List<Menu> selectSelfById(Long id);
}
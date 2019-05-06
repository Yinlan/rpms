package cn.xxx.basic.service;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.PageList;


import java.util.List;

public interface IBaseService<T> {

    void add(T t);

    void delete(Long id);

    void update(T t);

    T get(Long id);

    List<T> getAll();

    /**根据分页条件返回查询结果
     * @param query
     * @return
     */
    PageList<T> queryPage(BaseQuery query);
}

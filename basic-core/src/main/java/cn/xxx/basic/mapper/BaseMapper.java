package cn.xxx.basic.mapper;

import cn.xxx.basic.query.BaseQuery;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 基本的CRUD和分页查询
 * @param <T>
 */
public interface BaseMapper<T> {
    void insert(T t);

    void deleteByPrimaryKey(Long id);

    void updateByPrimaryKey(T t);

    T selectByPrimaryKey(Long id);

    List<T> selectAll();

    /**根据分页条件得到查询结果
     * @param query
     * @return
     */
    Page<T> loadDataByQuery(BaseQuery query);
}

package cn.xxx.basic.service.impl;


import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;


    public abstract class BaseServiceImpl<T> implements IBaseService<T> {

        //Basic没有引入spring相关包，不能使用注解注入，在具体service上实现本方法
        protected abstract BaseMapper<T> getMapper();

        @Override
    public void add(T t) {

        getMapper().insert(t);
       // int i=1/0;
    }

    @Override
    public void delete(Long id) {
        getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public void update(T t) {
        getMapper().updateByPrimaryKey(t);
    }

    @Override
    public T get(Long id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> getAll() {
        return getMapper().selectAll();
    }

    /**
     * 返回的pageList对象 其中含有总条数 和总数据
     */
    @Override
    public PageList<T> queryPage(BaseQuery query) {
        Page<T> objects = PageHelper.startPage(query.getPage(), query.getLimit());
        //拿到分页后的总数据
        getMapper().loadDataByQuery(query);
        return new PageList<>(objects.getTotal(), objects.getResult());
    }
}

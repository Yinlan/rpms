package cn.xxx.rpms.service;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.query.PartsQuery;

public interface IPartsService extends IBaseService<Parts>{
    Boolean checkNameQuery(PartsQuery partsQuery);
    void updateIndex();
    PageList<Parts> getByQuery(PartsQuery partsQuery) throws Exception;
}

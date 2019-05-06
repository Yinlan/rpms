package cn.xxx.rpms.service;

import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Opt;
import cn.xxx.rpms.query.OptQuery;

import java.text.ParseException;
import java.util.List;

public interface IOptService extends IBaseService<Opt> {
    PageList<Opt> loadDataByQueryLimt(OptQuery optQuery) throws Exception;
}

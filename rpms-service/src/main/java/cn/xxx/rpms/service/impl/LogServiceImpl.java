package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.rpms.domain.Log;
import cn.xxx.rpms.mapper.LogMapper;
import cn.xxx.rpms.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends BaseServiceImpl implements ILogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    protected BaseMapper getMapper() {
        return logMapper;
    }
}

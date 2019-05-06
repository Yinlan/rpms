package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.rpms.domain.PayType;
import cn.xxx.rpms.mapper.PayTypeMapper;
import cn.xxx.rpms.service.IPayTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayTypeServiceImpl extends BaseServiceImpl<PayType> implements IPayTypeService {
    @Autowired
    private PayTypeMapper payTypeMapper;
    @Override
    protected BaseMapper<PayType> getMapper() {
        return payTypeMapper;
    }

}

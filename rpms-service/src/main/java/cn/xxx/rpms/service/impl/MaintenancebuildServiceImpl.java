package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.Maintenancebuild;
import cn.xxx.rpms.domain.PayType;
import cn.xxx.rpms.mapper.MaintenanceMapper;
import cn.xxx.rpms.mapper.MaintenancebuildMapper;
import cn.xxx.rpms.mapper.PayTypeMapper;
import cn.xxx.rpms.query.MaintenanceBuildQuery;
import cn.xxx.rpms.service.IMaintenancebuildService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MaintenancebuildServiceImpl extends BaseServiceImpl<Maintenancebuild> implements IMaintenancebuildService {
    @Autowired
    private MaintenancebuildMapper maintenancebuildMapper;
    @Autowired
    private PayTypeMapper payTypeMapper;
    @Autowired
    private MaintenanceMapper maintenanceMapper;
    @Override
    protected BaseMapper<Maintenancebuild> getMapper() {
        return maintenancebuildMapper;
    }
    @Override
    public void add(Maintenancebuild maintenancebuild) {
        Long mainid = maintenancebuild.getMainid();//拿到主单id
        Long payid = maintenancebuild.getPayid();
        PayType payType = payTypeMapper.selectByPrimaryKey(payid);
        maintenancebuild.setPayType(payType);
        maintenancebuildMapper.insert(maintenancebuild);

        BigDecimal payAmount = maintenancebuild.getPayAmount();//实付金额
        BigDecimal reAmount = maintenancebuild.getReAmount();//应付金额

        if(payAmount !=null&&!"".equals(payAmount)&&payAmount.compareTo(reAmount)>-1){
            Maintenance maintenance = maintenanceMapper.selectByPrimaryKey(mainid);
            maintenance.setStatus(true);
            maintenanceMapper.updateByPrimaryKey(maintenance);
        }else{
            Maintenance maintenance = maintenanceMapper.selectByPrimaryKey(mainid);
            maintenance.setStatus(false);
            maintenanceMapper.updateByPrimaryKey(maintenance);
        }

    }

    @Override
    public PageList<Maintenancebuild> queryLimt(MaintenanceBuildQuery maintenanceBuildQuery) {
        Page<Maintenancebuild> objects = PageHelper.startPage(maintenanceBuildQuery.getPage(), maintenanceBuildQuery.getLimit());
        maintenancebuildMapper.loadDataByQueryLimt(maintenanceBuildQuery);
        return new PageList<>(objects.getTotal(), objects.getResult());
    }
}

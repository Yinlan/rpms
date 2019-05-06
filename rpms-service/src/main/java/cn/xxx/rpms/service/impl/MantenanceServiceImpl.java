package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.MaintenanceItem;
import cn.xxx.rpms.domain.Opt;
import cn.xxx.rpms.mapper.MaintenanceItemMapper;
import cn.xxx.rpms.mapper.MaintenanceMapper;
import cn.xxx.rpms.mapper.OptMapper;
import cn.xxx.rpms.query.MaintenanceQuery;
import cn.xxx.rpms.service.IMantenanceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenanceServiceImpl extends BaseServiceImpl<Maintenance> implements IMantenanceService {

    @Autowired
    private MaintenanceMapper maintenanceMapper;
    @Autowired
    private OptMapper optMapper;

    @Autowired
    private MaintenanceItemMapper maintenanceItemMapper;
    @Override
    protected BaseMapper<Maintenance> getMapper() {
        return maintenanceMapper;
    }

    @Override
    public void delete(Long id) {
        Maintenance maintenance = maintenanceMapper.selectByPrimaryKey(id);
        //将维修人员清空
        maintenance.setOpt(null);
        //维修单清空
        List<MaintenanceItem> maintenanceItems = maintenance.getMaintenanceItems();
        for(MaintenanceItem maintenanceItem:maintenanceItems){
            maintenanceItemMapper.deleteByPrimaryKey(maintenanceItem.getItemid());
        }
        maintenance.setMaintenanceItems(null);

        maintenanceMapper.deleteByPrimaryKey(id);

    }
    @Override
    public void update(Maintenance maintenance) {
        //修改明细单的维修员
        Long optid = maintenance.getOptid();
        List<MaintenanceItem> maintenanceItems = maintenance.getMaintenanceItems();
        for(MaintenanceItem maintenanceItem:maintenanceItems){
            maintenanceItem.setOpid(optid);
        }
        maintenanceMapper.updateByPrimaryKey(maintenance);
    }


    @Override
    public PageList<Maintenance> queryLimt(MaintenanceQuery maintenanceQuery) {
        Page<Maintenance> objects = PageHelper.startPage(maintenanceQuery.getPage(), maintenanceQuery.getLimit());
        maintenanceMapper.loadDataByQueryLimt(maintenanceQuery);
        return new PageList<>(objects.getTotal(), objects.getResult());
    }
}

package cn.xxx.rpms.service;

import cn.xxx.basic.service.IBaseService;
import cn.xxx.rpms.domain.MaintenanceItem;

public interface IMaintenanceItemService extends IBaseService<MaintenanceItem> {
    void addItem(MaintenanceItem maintenanceItem) throws Exception;
    void updateItem(MaintenanceItem maintenanceItem) throws Exception;
}

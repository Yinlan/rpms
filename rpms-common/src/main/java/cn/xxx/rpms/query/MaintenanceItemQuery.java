package cn.xxx.rpms.query;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.rpms.domain.MaintenanceItem;

public class MaintenanceItemQuery extends BaseQuery {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MaintenanceItemQuery{" +
                "id=" + id +
                '}';
    }
}

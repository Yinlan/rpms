package cn.xxx.rpms.query;

import cn.xxx.basic.query.BaseQuery;

public class MaintenanceBuildQuery extends BaseQuery {
    private String custormer;

    public String getCustormer() {
        return custormer;
    }

    public void setCustormer(String custormer) {
        this.custormer = custormer;
    }
}

package cn.xxx.rpms.query;

import cn.xxx.basic.query.BaseQuery;

public class PartsQuery extends BaseQuery {
    //用来做表单验证的 如果有查出来的名字相同则可以通过
    private Long pid;
    //做查询的名字
    private String partsname;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPartsname() {
        return partsname;
    }

    public void setPartsname(String partsname) {
        this.partsname = partsname;
    }
}

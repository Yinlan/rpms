package cn.xxx.rpms.query;

import cn.xxx.basic.query.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OptQuery extends BaseQuery {
    private String optname;
    private Date bignDate;
    private Date endDate;

    public String getOptname() {
        return optname;
    }
    public void setOptname(String optname) {
        this.optname = optname;
    }

    public Date getBignDate() {
        return bignDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBignDate(Date bignDate) {
        this.bignDate = bignDate;
    }


    public Date getEndDate() {
        return endDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

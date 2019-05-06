package cn.xxx.rpms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
//配件
public class Parts {
    private Long pid;

    private String partsname;

    private Long price;

    private Integer num;

    private Integer warnnum;

    private String context;

    private Date createtime=new Date();

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
        this.partsname = partsname == null ? null : partsname.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getWarnnum() {
        return warnnum;
    }

    public void setWarnnum(Integer warnnum) {
        this.warnnum = warnnum;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "pid=" + pid +
                ", partsname='" + partsname + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", warnnum=" + warnnum +
                ", context='" + context + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
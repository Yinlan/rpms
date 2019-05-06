package cn.xxx.rpms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//维修录入单
public class Maintenance {
    //主键
    private Long mainid;
    //客户名称
    private String custormer;
    //车牌号
    private String carnum;
    //维修单时间
    private Date createtime=new Date();
    //维修单状态 默认false 已录入
    private Boolean status=false;
//    维修人员  配置多对一
    private Opt opt;
    private Long optid;
    //客户地址
    private String address;
    //配置一对多 从维修录入单找明细单
    List<MaintenanceItem> maintenanceItems =new ArrayList<>();

    public Long getOptid() {
        return optid;
    }

    public void setOptid(Long optid) {
        this.optid = optid;
    }

    public List<MaintenanceItem> getMaintenanceItems() {
        return maintenanceItems;
    }

    public void setMaintenanceItems(List<MaintenanceItem> maintenanceItems) {
        this.maintenanceItems = maintenanceItems;
    }

    public Opt getOpt() {
        return opt;
    }

    public void setOpt(Opt opt) {
        this.opt = opt;
    }


    public Long getMainid() {
        return mainid;
    }

    public void setMainid(Long mainid) {
        this.mainid = mainid;
    }

    public String getCustormer() {
        return custormer;
    }

    public void setCustormer(String custormer) {
        this.custormer = custormer == null ? null : custormer.trim();
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum == null ? null : carnum.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "mainid=" + mainid +
                ", custormer='" + custormer + '\'' +
                ", carnum='" + carnum + '\'' +
                ", createtime=" + createtime +
                ", status=" + status +
                ", opt=" + opt +
                ", maintenanceItems=" + maintenanceItems +
                ", address='" + address + '\'' +
                '}';
    }
}
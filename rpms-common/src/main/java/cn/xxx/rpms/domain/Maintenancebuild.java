package cn.xxx.rpms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
//结算单
public class Maintenancebuild {
    //结算单id
    private Long sid;
    //顾客
    private String custormer;
    //结算单对应的录入单
    private Long mainid;
    //结算单时间
    private Date settedtime=new Date();
    //应付金额
    private BigDecimal reAmount;

    //实付金额
    private BigDecimal payAmount;
    //支付方式
    private PayType payType;
    private Long payid;

    public Long getPayid() {
        return payid;
    }

    public void setPayid(Long payid) {
        this.payid = payid;
    }

    public Long getMainid() {
        return mainid;
    }

    public void setMainid(Long mainid) {
        this.mainid = mainid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getCustormer() {
        return custormer;
    }

    public void setCustormer(String custormer) {
        this.custormer = custormer == null ? null : custormer.trim();
    }


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getSettedtime() {
        return settedtime;
    }

    public void setSettedtime(Date settedtime) {
        this.settedtime = settedtime;
    }

    public BigDecimal getReAmount() {
        return reAmount;
    }

    public void setReAmount(BigDecimal reAmount) {
        this.reAmount = reAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "Maintenancebuild{" +
                "sid=" + sid +
                ", custormer='" + custormer + '\'' +
                ", mainid=" + mainid +
                ", settedtime=" + settedtime +
                ", reAmount=" + reAmount +
                ", payAmount=" + payAmount +
                ", payType=" + payType +
                ", payid=" + payid +
                '}';
    }
}
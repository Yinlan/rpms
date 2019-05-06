package cn.xxx.rpms.domain;

import java.math.BigDecimal;

//维修明细表
public class MaintenanceItem {
    //主键
    private Long itemid;
    //录入单
    private Long mainid;
    //维修人员id
    private Long opid;
    //维修配件id
    private Long pid;
    //维修配件
    private Parts parts;
    //配件价格
    private BigDecimal amt1;
    //工时费
    private BigDecimal amt2;
    //配件数量
    private Integer num;
    //总金额
    private BigDecimal totalamt;

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }


    public Long getOpid() {
        return opid;
    }

    public void setOpid(Long opid) {
        this.opid = opid;
    }


    public Long getMainid() {
        return mainid;
    }

    public void setMainid(Long mainid) {
        this.mainid = mainid;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public BigDecimal getAmt1() {
        return amt1;
    }

    public void setAmt1(BigDecimal amt1) {
        this.amt1 = amt1;
    }

    public BigDecimal getAmt2() {
        return amt2;
    }

    public void setAmt2(BigDecimal amt2) {
        this.amt2 = amt2;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(BigDecimal totalamt) {
        this.totalamt = totalamt;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "MaintenanceItem{" +
                "itemid=" + itemid +
                ", mainid=" + mainid +
                ", opid=" + opid +
                ", pid=" + pid +
                ", parts=" + parts +
                ", amt1=" + amt1 +
                ", amt2=" + amt2 +
                ", num=" + num +
                ", totalamt=" + totalamt +
                '}';
    }
}
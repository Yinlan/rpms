package cn.xxx.rpms.domain.vo;

public class MaintenanceItemVo {
    private Long itemid;

    private Long mainid;

    private Long opid;

    private Long pid;

    private Long amt1;

    private Long amt2;

    private Integer num;

    private Long totalamt;

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public Long getMainid() {
        return mainid;
    }

    public void setMainid(Long mainid) {
        this.mainid = mainid;
    }

    public Long getOpid() {
        return opid;
    }

    public void setOpid(Long opid) {
        this.opid = opid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getAmt1() {
        return amt1;
    }

    public void setAmt1(Long amt1) {
        this.amt1 = amt1;
    }

    public Long getAmt2() {
        return amt2;
    }

    public void setAmt2(Long amt2) {
        this.amt2 = amt2;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(Long totalamt) {
        this.totalamt = totalamt;
    }
}
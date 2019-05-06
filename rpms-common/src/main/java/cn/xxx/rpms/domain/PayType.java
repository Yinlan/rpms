package cn.xxx.rpms.domain;

public class PayType {
    private Long payid;

    private String paytypename;

    public Long getPayid() {
        return payid;
    }

    public void setPayid(Long payid) {
        this.payid = payid;
    }

    public String getPaytypename() {
        return paytypename;
    }

    public void setPaytypename(String paytypename) {
        this.paytypename = paytypename == null ? null : paytypename.trim();
    }

    @Override
    public String toString() {
        return "PayType{" +
                "payid=" + payid +
                ", paytypename='" + paytypename + '\'' +
                '}';
    }
}
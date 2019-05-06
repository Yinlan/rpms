package cn.xxx.rpms.domain;

public class Menu_Employee {
    private Long id;

    private Long mid;

    private Long eid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "Menu_Employee{" +
                "id=" + id +
                ", mid=" + mid +
                ", eid=" + eid +
                '}';
    }
}
package cn.xxx.rpms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//维修人员
public class Opt {
    private Long optid;

    private String optname;

    private Integer age;

    private String email;

    private Date hiredate;

    public Long getOptid() {
        return optid;
    }

    public void setOptid(Long optid) {
        this.optid = optid;
    }

    public String getOptname() {
        return optname;
    }

    public void setOptname(String optname) {
        this.optname = optname == null ? null : optname.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getHiredate() {
        return hiredate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Opt{" +
                "optid=" + optid +
                ", optname='" + optname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }
}
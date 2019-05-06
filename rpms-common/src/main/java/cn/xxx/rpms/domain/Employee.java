package cn.xxx.rpms.domain;

import java.util.ArrayList;
import java.util.List;

//员工表
public class Employee {
    //主键id
    private Long id;
    //姓名
    private String name;
    //密码
    private String pwd;
    //年龄
    private Integer age;
    //电话号码
    private Long tel;
    //邮件
    private String email;
    //角色
    private List<Role> roles=new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
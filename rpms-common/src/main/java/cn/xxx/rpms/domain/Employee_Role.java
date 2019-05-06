package cn.xxx.rpms.domain;

public class Employee_Role {
    private Long id;

    private Long employeeId;

    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Employee_Role{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", roleId=" + roleId +
                '}';
    }
}
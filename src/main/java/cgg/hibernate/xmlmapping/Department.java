package cgg.hibernate.xmlmapping;

import java.util.List;

public class Department {

    private int deptId;
    private String deptName;

    private List<Employeee> employees;

    public List<Employeee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employeee> employees) {
        this.employees = employees;
    }

    public Department(int deptId, String deptName) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Department() {
        super();
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
    }

}

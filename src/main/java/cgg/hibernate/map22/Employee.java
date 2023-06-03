package cgg.hibernate.map22;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@Column(name="emp_id")
	private int empId;
	@Column(name="emp_name")
	private String empName;
	
	@ManyToMany
	@JoinTable(name="employees", joinColumns = @JoinColumn(name="emp_id"),inverseJoinColumns=@JoinColumn(name="proj_id"))
	private List<Project> pList;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName, List<Project> pList) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.pList = pList;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<Project> getPlist() {
		return pList;
	}

	public void setPList(List<Project> pList) {
		this.pList = pList;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", pList=" + pList + "]";
	}
	
}

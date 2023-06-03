package cgg.hibernate.map22;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@Column(name="p_id")
	private int projId;
	@Column(name="p_name")
	private String projectName;
	
	@ManyToMany(mappedBy="pList")
	private List<Employee> empList;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projId, String projectName, List<Employee> empList) {
		super();
		this.projId = projId;
		this.projectName = projectName;
		this.empList = empList;
	}

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projectName=" + projectName + ", empList=" + empList + "]";
	}
	
	
}

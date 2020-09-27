package entity;

import java.time.LocalDate;

public class Project {
	protected String id;
	protected String name;
	protected String department_id;
	protected String description;
	protected int part;
	protected String project_type_id;
	protected LocalDate datenew;
	protected boolean status;
	
	public Project() {};
	
	public Project(String id, String name, String department_id, String description, int part, String project_type_id) {
		this.id = id;
		this.name = name;
		this.department_id = department_id;
		this.description = description;
		this.part = part;
		this.project_type_id = project_type_id;
	}
	
	public Project(String id, String name, String department_id, String description, int part, String project_type_id,
			LocalDate datenew) {
		this.id = id;
		this.name = name;
		this.department_id = department_id;
		this.description = description;
		this.part = part;
		this.project_type_id = project_type_id;
		this.datenew = datenew;
	}
	
	public Project(String id, String name, String department_id, String description, int part, String project_type_id,
			LocalDate datenew, boolean status) {
		this.id = id;
		this.name = name;
		this.department_id = department_id;
		this.description = description;
		this.part = part;
		this.project_type_id = project_type_id;
		this.datenew = datenew;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	public String getProject_type_id() {
		return project_type_id;
	}
	public void setProject_type_id(String project_type_id) {
		this.project_type_id = project_type_id;
	}
	public LocalDate getDatenew() {
		return datenew;
	}
	public void setDatenew(LocalDate datenew) {
		this.datenew = datenew;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", department_id=" + department_id + ", description="
				+ description + ", part=" + part + ", project_type_id=" + project_type_id + ", datenew=" + datenew
				+ ", status=" + status + "]";
	}
	
	
	
}

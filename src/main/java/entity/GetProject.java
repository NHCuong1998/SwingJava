package entity;

import java.time.LocalDate;

public class GetProject {
	private String id;
	private String name;
	private LocalDate date;
	private String description;
	private boolean status;
	private String type_name;
	private String department_name;
	private String branch_name;
	
	public GetProject(){}
	public GetProject(String id, String name, LocalDate date, String description, boolean status, String type_name,
			String department_name, String branch_name) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.description = description;
		this.status = status;
		this.type_name = type_name;
		this.department_name = department_name;
		this.branch_name = branch_name;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	@Override
	public String toString() {
		return "GetProject [id=" + id + ", name=" + name + ", date=" + date + ", description=" + description
				+ ", status=" + status + ", type_name=" + type_name + ", department_name=" + department_name
				+ ", branch_name=" + branch_name + "]";
	}
	
	
}

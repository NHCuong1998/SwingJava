package entity;

import java.time.LocalDate;

public class Transfer {
	private String id;
	private String type;
	private String emp_id;
	private String department_old;
	private String department_new;
	private String project_old;
	private String project_new;
	private String description;
	private boolean status;
	private LocalDate date;
	private int part;
	private boolean check;
	
	
	public Transfer() {
	}
	public Transfer(String id, String type, String emp_id, String department_old, String department_new,
			String project_old, String project_new, String description, boolean status, LocalDate date, int part, boolean check) {
		this.id = id;
		this.type = type;
		this.emp_id = emp_id;
		this.department_old = department_old;
		this.department_new = department_new;
		this.project_old = project_old;
		this.project_new = project_new;
		this.description = description;
		this.status = status;
		this.date = date;
		this.part = part;
		this.check = check;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getDepartment_old() {
		return department_old;
	}

	public void setDepartment_old(String department_old) {
		this.department_old = department_old;
	}

	public String getDepartment_new() {
		return department_new;
	}

	public void setDepartment_new(String department_new) {
		this.department_new = department_new;
	}

	public String getProject_old() {
		return project_old;
	}

	public void setProject_old(String project_old) {
		this.project_old = project_old;
	}

	public String getProject_new() {
		return project_new;
	}

	public void setProject_new(String project_new) {
		this.project_new = project_new;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPart() {
		return part;
	}

	public void setPart(int part) {
		this.part = part;
	}
	
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "Transfer [id=" + id + ", type=" + type + ", emp_id=" + emp_id + ", department_old=" + department_old
				+ ", department_new=" + department_new + ", project_old=" + project_old + ", project_new=" + project_new
				+ ", description=" + description + ", status=" + status + ", date=" + date + ", part=" + part
				+ ", check=" + check + "]";
	}
	
	

		

}

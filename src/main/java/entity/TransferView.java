package entity;

import java.time.LocalDate;

public class TransferView extends Transfer1 {
	private String department_name_old;
	private String department_name_new;
	private String project_name_old;
	private String project_name_new;
	private String employee_name;
	private String type_name;
	private LocalDate date;
	
	
	public TransferView() {}
	public TransferView(String id, String type, String employee_id, String department_old, String department_new,
			String project_old, String project_new, String description, boolean check, boolean status,String department_name_old, String department_name_new, String project_name_old,
			String project_name_new, String employee_name, String type_name, LocalDate date) {
		super(id, type, employee_id, department_old, department_new, project_old, project_new, description, check,
				status);
		this.department_name_old = department_name_old;
		this.department_name_new = department_name_new;
		this.project_name_old = project_name_old;
		this.project_name_new = project_name_new;
		this.employee_name = employee_name;
		this.type_name = type_name;
		this.date=date;
	}
	
	public String getDepartment_name_old() {
		return department_name_old;
	}
	public void setDepartment_name_old(String department_name_old) {
		this.department_name_old = department_name_old;
	}
	public String getDepartment_name_new() {
		return department_name_new;
	}
	public void setDepartment_name_new(String department_name_new) {
		this.department_name_new = department_name_new;
	}
	public String getProject_name_old() {
		return project_name_old;
	}
	public void setProject_name_old(String project_name_old) {
		this.project_name_old = project_name_old;
	}
	public String getProject_name_new() {
		return project_name_new;
	}
	public void setProject_name_new(String project_name_new) {
		this.project_name_new = project_name_new;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "TransferView [department_name_old=" + department_name_old + ", department_name_new="
				+ department_name_new + ", project_name_old=" + project_name_old + ", project_name_new="
				+ project_name_new + ", employee_name=" + employee_name + ", type_name=" + type_name + ", date=" + date
				+ "]";
	}

}

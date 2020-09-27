package entity;

import java.time.LocalDate;

public class TransferLog {
	private String employee_id;
	private String description;
	private String old;
	private String newname;
	private String userCheck;
	private LocalDate date;
	private Boolean check;
	private int part;
	
	public TransferLog() {}
	public TransferLog(String employee_id, String description, String old, String newname, String userCheck, LocalDate date , Boolean check, int part) {

		this.employee_id = employee_id;
		this.description = description;
		this.old = old;
		this.newname = newname;
		this.userCheck=userCheck;
		this.date=date;
		this.check = check;
		this.part = part;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getUserCheck() {
		return userCheck;
	}
	public void setUserCheck(String userCheck) {
		this.userCheck = userCheck;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getNewname() {
		return newname;
	}
	public void setNewname(String newname) {
		this.newname = newname;
	}
	public Boolean getCheck() {
		return check;
	}
	public void setCheck(Boolean check) {
		this.check = check;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	@Override
	public String toString() {
		return "TransferLog [employee_id=" + employee_id + ", description=" + description + ", old=" + old
				+ ", newname=" + newname + ", check=" + check + ", part=" + part + "]";
	}
	
	
}

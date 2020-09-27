package entity;

import java.sql.Timestamp;

public class Assignment1 {
	protected int id;
	protected String project_id;
	protected String employee_id;
	protected Timestamp datejoin;
	protected boolean status;
	protected boolean done;
	
	public Assignment1() {};
	public Assignment1(int id, String project_id, String employee_id, Timestamp datejoin, boolean status,
			boolean done) {
		this.id = id;
		this.project_id = project_id;
		this.employee_id = employee_id;
		this.datejoin = datejoin;
		this.status = status;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public Timestamp getDatejoin() {
		return datejoin;
	}
	public void setDatejoin(Timestamp datejoin) {
		this.datejoin = datejoin;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean getDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "Assignment [id=" + id + ", project_id=" + project_id + ", employee_id=" + employee_id + ", datejoin="
				+ datejoin + ", status=" + status + ", done=" + done + "]";
	}
	
	
	
}

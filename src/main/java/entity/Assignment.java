package entity;

import java.sql.Timestamp;

public class Assignment {
	protected String id;
	protected String project_id;
	protected String employee_id;
	protected Timestamp datejoin;
	protected int done;
	protected boolean status;

	
	public Assignment() {}


	public Assignment(String id, String project_id, String employee_id, Timestamp datejoin, int done, boolean status) {
		this.id = id;
		this.project_id = project_id;
		this.employee_id = employee_id;
		this.datejoin = datejoin;
		this.done = done;
		this.status = status;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
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


	public int getDone() {
		return done;
	}


	public void setDone(int done) {
		this.done = done;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Assignment [id=" + id + ", project_id=" + project_id + ", employee_id=" + employee_id + ", datejoin="
				+ datejoin + ", done=" + done + ", status=" + status + "]";
	}

	
}

package entity;

import java.sql.Timestamp;

public class AssignmentUser {
	
	protected int id;
	protected String name_project;
	protected Timestamp datejoin;
	protected int done;
	protected boolean status;
	
	
	
	public AssignmentUser() {}

	public AssignmentUser(int id, String name_project, Timestamp datejoin, int done, boolean status) {
		super();
		this.id = id;
		this.name_project = name_project;
		this.datejoin = datejoin;
		this.done = done;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_project() {
		return name_project;
	}

	public void setName_project(String name_project) {
		this.name_project = name_project;
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
		return "AssignmentUser [id=" + id + ", name_project=" + name_project + ", datejoin=" + datejoin + ", done="
				+ done + ", status=" + status + "]";
	}
	
	

}

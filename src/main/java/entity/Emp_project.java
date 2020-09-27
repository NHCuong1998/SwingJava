package entity;

import java.time.LocalDate;

public class Emp_project {
	private String nameProject;
	private String nameProject_type;
	private LocalDate datejoin;
	private LocalDate datenew;
	private int dont;
	
	
	public Emp_project() {	
	}
	
	public Emp_project(String nameProject, String nameProject_type, LocalDate datejoin,LocalDate datenew, int dont) {
		super();
		this.nameProject = nameProject;
		this.nameProject_type = nameProject_type;
		this.datejoin = datejoin;
		this.datenew = datenew;
		this.dont = dont;
		
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public String getNameProject_type() {
		return nameProject_type;
	}

	public void setNameProject_type(String nameProject_type) {
		this.nameProject_type = nameProject_type;
	}

	public LocalDate getDatejoin() {
		return datejoin;
	}

	public void setDatejoin(LocalDate datejoin) {
		this.datejoin = datejoin;
	}
	
	public LocalDate getDatenew() {
		return datenew;
	}

	public void setDatenew(LocalDate datenew) {
		this.datenew = datenew;
	}

	public int getDont() {
		return dont;
	}

	public void setDont(int dont) {
		this.dont = dont;
	}

	@Override
	public String toString() {
		return "Emp_project [nameProject=" + nameProject + ", nameProject_type=" + nameProject_type + ", datejoin="
				+ datejoin + ", datenew=" + datenew + ", dont=" + dont + "]";
	}

	
	
	
	
}

package entity;

import java.time.LocalDate;

public class Project_branch {
	private String id;
	private String name_project;
	private String name_project_type;
	private String description;
	private LocalDate datenew;
	
	public Project_branch() {
	}
	
	public Project_branch(String id, String name_project, String name_project_type, String description,
			LocalDate datenew) {
		this.id = id;
		this.name_project = name_project;
		this.name_project_type = name_project_type;
		this.description = description;
		this.datenew = datenew;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName_project() {
		return name_project;
	}

	public void setName_project(String name_project) {
		this.name_project = name_project;
	}

	public String getName_project_type() {
		return name_project_type;
	}

	public void setName_project_type(String name_project_type) {
		this.name_project_type = name_project_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDatenew() {
		return datenew;
	}

	public void setDatenew(LocalDate datenew) {
		this.datenew = datenew;
	}

	@Override
	public String toString() {
		return "Project_branch [id=" + id + ", name_project=" + name_project + ", name_project_type="
				+ name_project_type + ", description=" + description + ", datenew=" + datenew + "]";
	}
	
	
	
	

}

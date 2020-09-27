package entity;

public class Project_type {
	protected String id;
	protected String name;
	protected boolean status;
	
	public Project_type() {}
	public Project_type(String id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Project_type [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
	
}

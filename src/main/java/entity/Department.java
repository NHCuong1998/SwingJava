package entity;

public class Department {

	protected String id;
	protected String name;
	protected String branch_id;
	protected boolean status;
	
	public Department() {};
	public Department(String id, String name, String branch_id, boolean status) {
		this.id = id;
		this.name = name;
		this.branch_id = branch_id;
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

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "[" + id + "] - " + name ;
	}
	
}

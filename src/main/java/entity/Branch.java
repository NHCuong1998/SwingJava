package entity;

public class Branch {
	private String id;
	private String name;
	private boolean status ;
	
	public Branch() {};
	public Branch(String id, String name, boolean status) {
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
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "[" + id + "] " + name ;
	}
	
	
}

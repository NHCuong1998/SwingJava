package entity;

public class SystemInfo {
	private int max_branch;
	private int max_department;
	private int max_project;
	
	public SystemInfo() {}
	public SystemInfo(int max_branch, int max_department, int max_project) {
		super();
		this.max_branch = max_branch;
		this.max_department = max_department;
		this.max_project = max_project;
	}
	public int getMax_branch() {
		return max_branch;
	}
	public void setMax_branch(int max_branch) {
		this.max_branch = max_branch;
	}
	public int getMax_department() {
		return max_department;
	}
	public void setMax_department(int max_department) {
		this.max_department = max_department;
	}
	public int getMax_project() {
		return max_project;
	}
	public void setMax_project(int max_project) {
		this.max_project = max_project;
	}
	@Override
	public String toString() {
		return "SystemInfo [max_branch=" + max_branch + ", max_department=" + max_department + ", max_project="
				+ max_project + "]";
	}
	
}

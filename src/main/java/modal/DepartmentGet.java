package modal;

import entity.Department;

public class DepartmentGet extends Department {
	private String branch_name;
	
	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public DepartmentGet() {
		
	}

	public DepartmentGet(String id, String name, String branch_id, boolean status) {
		super(id, name, branch_id, status);
	}

	public DepartmentGet(String id, String name, String branch_id, boolean status,String branch_name) {
		super(id, name, branch_id, status);
		this.branch_name = branch_name;
	}

	@Override
	public String toString() {
		return "DepartmentGet [branch_name=" + branch_name + "]";
	}
	

}

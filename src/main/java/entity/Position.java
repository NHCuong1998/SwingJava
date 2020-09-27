package entity;

public class Position {
	protected String id;
	protected String name;
	protected boolean status;
	protected String listBranch;
	protected String listDepartment;
	private String branch_id;
	
	public Position() {}
	public Position(String id, String name, boolean status, String listBranch, String listDepartment, String branch_id) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.listBranch = listBranch;
		this.listDepartment=listDepartment;
		this.branch_id=branch_id;
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
	
	public String getListBranch() {
		return listBranch;
	}
	public void setListBranch(String listBranch) {
		this.listBranch = listBranch;
	}
	public String getListDepartment() {
		return listDepartment;
	}
	public void setListDepartment(String listDepartment) {
		this.listDepartment = listDepartment;
	}
	
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
//	@Override
//	public String toString() {
//		return "Position [id=" + id + ", name=" + name + ", status=" + status + "]";
//	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", status=" + status + ", listBranch=" + listBranch
				+ ", listDepartment=" + listDepartment + ", branch_id=" + branch_id + "]";
	}
	
	
	
}

package entity;

public class CurrentUser {
	private String username;
	private boolean isAdmin;
	private String branchId;
	private String positionId;
	private String listBranch;
	private String listDepartment;
	private String listProject;
	
	public CurrentUser() {}
	
	public CurrentUser(String username, boolean isAdmin, String branchId, String positionId, String listBranch,
			String listDepartment, String listProject) {
		super();
		this.username = username;
		this.isAdmin = isAdmin;
		this.branchId = branchId;
		this.positionId = positionId;
		this.listBranch = listBranch;
		this.listDepartment = listDepartment;
		this.listProject = listProject;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
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
	public String getListProject() {
		return listProject;
	}
	public void setListProject(String listProject) {
		this.listProject = listProject;
	}
	@Override
	public String toString() {
		return "CurrentUser [username=" + username + ", isAdmin=" + isAdmin + ", branchId=" + branchId + ", positionId="
				+ positionId + ", listBranch=" + listBranch + ", listDepartment=" + listDepartment + ", listProject="
				+ listProject + "]";
	}
	
	
}

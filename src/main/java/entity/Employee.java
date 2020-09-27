package entity;

public class Employee {
	protected String id;
	protected String password;
	protected String name;
	protected String department_id;
	protected String position_id;
	protected boolean login;
	protected boolean status;
	
	public Employee() {}
	public Employee(String id, String password, String name, String department_id, String position_id, boolean login,
			boolean status) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.department_id = department_id;
		this.position_id = position_id;
		this.login = login;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getPosition_id() {
		return position_id;
	}
	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", password=" + password + ", name=" + name + ", department_id=" + department_id
				+ ", position_id=" + position_id + ", login=" + login + ", status=" + status + "]";
	}
	
	
}

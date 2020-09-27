package entity;

public class Transfer1 {
	protected String id;
	protected String type;
	protected String employee_id;
	protected String department_old;
	protected String department_new;
	protected String project_old;
	protected String project_new;
	protected String description;
	protected boolean check;
	protected boolean status;

	public Transfer1() {
	}

	public Transfer1(String id, String type, String employee_id, String department_old, String department_new,
			String project_old, String project_new, String description, boolean check, boolean status) {
		super();
		this.id = id;
		this.type = type;
		this.employee_id = employee_id;
		this.department_old = department_old;
		this.department_new = department_new;
		this.project_old = project_old;
		this.project_new = project_new;
		this.description = description;
		this.check = check;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getDepartment_old() {
		return department_old;
	}

	public void setDepartment_old(String department_old) {
		this.department_old = department_old;
	}

	public String getDepartment_new() {
		return department_new;
	}

	public void setDepartment_new(String department_new) {
		this.department_new = department_new;
	}

	public String getProject_old() {
		return project_old;
	}

	public void setProject_old(String project_old) {
		this.project_old = project_old;
	}

	public String getProject_new() {
		return project_new;
	}

	public void setProject_new(String project_new) {
		this.project_new = project_new;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", type=" + type + ", employee_id=" + employee_id + ", department_old="
				+ department_old + ", department_new=" + department_new + ", project_old=" + project_old
				+ ", project_new=" + project_new + ", description=" + description + ", check=" + check + ", status="
				+ status + "]";
	}
}

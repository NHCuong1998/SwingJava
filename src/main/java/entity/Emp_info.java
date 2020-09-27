package entity;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Emp_info  extends Employee{
	protected String employee_id;
	protected String address;
	protected String education;
	protected String specialize;
	protected String phone;
	protected String email;
	protected Timestamp datejoin;
	

	public Emp_info() {};
	public Emp_info(String employee_id, String address, String education, String specialize, String phone, String email,
			Timestamp datejoin) {
		super();
		this.employee_id = employee_id;
		this.address = address;
		this.education = education;
		this.specialize = specialize;
		this.phone = phone;
		this.email = email;
		this.datejoin = datejoin;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSpecialize() {
		return specialize;
	}

	public void setSpecialize(String specialize) {
		this.specialize = specialize;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDatejoin() {
		return datejoin;
	}

	public void setDatejoin(Timestamp datejoin) {
		this.datejoin = datejoin;
	}

	@Override
	public String toString() {
		return "Emp_info [employee_id=" + employee_id + ", address=" + address + ", education=" + education
				+ ", specialize=" + specialize + ", phone=" + phone + ", email=" + email + ", datejoin=" + datejoin
				+ "]";
	}
	
	
}

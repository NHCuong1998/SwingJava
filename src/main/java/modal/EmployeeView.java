package modal;

import java.time.LocalDate;

public class EmployeeView {

	private String id;
	private String name;
	private String department_id;
	private String position_id;
	private boolean status;
	private String address;
	private String education;
	private String specialize;
	private String phone;
	private String email;
	private LocalDate datejoin;
	private String gender;
	private String genderName;
	
	public EmployeeView() {}
	public EmployeeView(String id, String name, String department_id, String position_id, boolean status,
			String address, String education, String specialize, String phone, String email, LocalDate datejoin, String gender, String genderName) {
		this.id = id;
		this.name = name;
		this.department_id = department_id;
		this.position_id = position_id;
		this.status = status;
		this.address = address;
		this.education = education;
		this.specialize = specialize;
		this.phone = phone;
		this.email = email;
		this.datejoin = datejoin;
		this.gender = gender;
		this.genderName = genderName;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public LocalDate getDatejoin() {
		return datejoin;
	}
	public void setDatejoin(LocalDate datejoin) {
		this.datejoin = datejoin;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	@Override
	public String toString() {
		return "EmployeeView [id=" + id + ", name=" + name + ", department_id=" + department_id + ", position_id="
				+ position_id + ", status=" + status + ", address=" + address + ", education=" + education
				+ ", specialize=" + specialize + ", phone=" + phone + ", email=" + email + ", datejoin=" + datejoin
				+ ", gender=" + gender + ",genderName=" + genderName + "]";
	}

}

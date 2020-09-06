package model;

public class Doctor extends Person {
	private String speciality;
	private Integer consultFee;
	private String department;
	private String status;
	private String password;

	public Doctor(String id, String password, String firstName, String lastName, int age, String address,
			String bloodGroup, String phoneNumber, String speciality, Integer consultFee, String department) {
		super(id, firstName, lastName, age, address, bloodGroup, phoneNumber);
		this.speciality = speciality;
		this.consultFee = consultFee;
		this.department = department;
		this.password = password;
		this.status = "Available";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Integer getConsultFee() {
		return consultFee;
	}

	public void setConsultFee(Integer consultFee) {
		this.consultFee = consultFee;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Doctor [ Id=" + getId() + ", speciality=" + speciality + ", Department=" + department + ", ConsultFee="
				+ consultFee + ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + ", Status="
				+ getStatus() + ", Age=" + getAge() + ", Address=" + getAddress() + ", BloodGroup=" + getBloodGroup()
				+ ", PhoneNumber=" + getPhoneNumber() + "] \n";
	}

}

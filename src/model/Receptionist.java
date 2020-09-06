package model;

public class Receptionist extends Person {
private String password;
	public Receptionist(String id,String password, String firstName, String lastName, int age, String address, String bloodGroup,
			String phoneNumber) {
		super(id, firstName, lastName, age, address, bloodGroup, phoneNumber);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\nReceptionist [ Id=" + getId()+", FirstName=" + getFirstName() + ", LastName=" + getLastName() + ", Age="
				+ getAge() + ", Address=" + getAddress() + ", BloodGroup=" + getBloodGroup()
				+ ", PhoneNumber=" + getPhoneNumber() +"]\n";
	}

}

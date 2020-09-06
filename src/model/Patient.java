package model;

public class Patient extends Person {

	private Rooms RoomNo;
	private String disease;
	private String department;
	private double payBill;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String id, String firstName, String lastName, int age, String address, String bloodGroup,
			String phoneNumber, String disease, String department) {
		super(id, firstName, lastName, age, address, bloodGroup, phoneNumber);
		this.disease = disease;
		this.department = department;
	}

	public Patient(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Rooms getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(Rooms roomNo) {
		RoomNo = roomNo;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	public double getPayBill() {
		return payBill;
	}

	public void setPayBill(double payBill) {
		this.payBill = payBill;
	}

	@Override
	public String toString() {
		return "\nPatient [ Id=" + getId() + ", RoomNo=" + RoomNo +", PayBill=" + payBill + ", FirstName=" + getFirstName() + ", LastName=" + getLastName()
				+ ", Age=" + getAge() + ", Address=" + getAddress() + ", BloodGroup=" + getBloodGroup()
				+ ", PhoneNumber=" + getPhoneNumber() + ", Disease= " + getDisease() + ", Department=" + getDepartment() + "]\n";
	}
}

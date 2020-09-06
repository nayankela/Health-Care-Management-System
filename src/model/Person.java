package model;

public class Person extends BaseEntity {
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String bloodGroup;
	private String phoneNumber;

	public Person(String id, String firstName, String lastName, int age, String address, String bloodGroup,
			String phoneNumber) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.phoneNumber = phoneNumber;

	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", bloodGroup=" + bloodGroup + ", phoneNumber=" + phoneNumber + "]";
	}

}

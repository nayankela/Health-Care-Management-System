package interfacesImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import interfaces.BaseInterface;
import model.Doctor;
import services.DoctorCRUD;
import utility.RegistrationValidation;

public class DoctorImpl implements BaseInterface {

	static List<Doctor> doctors = new ArrayList<Doctor>();
	DoctorCRUD doctorOperations = new DoctorCRUD();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	RegistrationValidation reValidation = new RegistrationValidation();

	// ADD Doctor
	@Override
	public void add() {
		boolean flags = true;
		try {
			String id = "";
			do {
				System.out.println("Enter Id:");
				id = reader.readLine();
				if (reValidation.id(id)) {
					if (!getAllDoctors().isEmpty()) {
						for (Doctor doctor : getAllDoctors()) {
							if (doctor.getId().equalsIgnoreCase(id)) {
								System.out.println("This ID already Existed");
								flags = true;
								break;
							} else {
								flags = false;
							}
						}
					} else {
						flags = false;
					}
				} else {
					System.out.println(
							" 1. Left part has fixed 2 capital English letters.\n 2. Right part has digits where length of digits between 2 and 5.");
				}
			} while (flags);
			String password = "";
			boolean flagPass = true;
			while (flagPass) {
				System.out.println("Enter Password:");
				password = reader.readLine();
				if (reValidation.validPassword(password)) {
					flagPass = false;
				} else {
					System.out.println(
							"Password Should Contain Atleast 1 UpperCase, Lowercase & Symbol\n Must be 8 characters upto 20 Characters");
				}
			}
			String firstName = "";
			int counter2 = 0;
			while (counter2 <= 0) {
				System.out.println("Enter First Name:");
				firstName = reader.readLine();
				if (reValidation.name(firstName)) {
					++counter2;
				} else {
					System.out.println("Enter Valid First Name & must Start with Capital Letter");
				}
			}
			String lastName = "";
			int counter3 = 0;
			while (counter3 <= 0) {
				System.out.println("Enter Last Name");
				lastName = reader.readLine();
				if (reValidation.name(lastName)) {
					++counter3;
				} else {
					System.out.println("Enter Valid Last Name & must Start with Capital Letters");
				}
			}
			int age = 0;
			boolean flagAge = true;
			while (flagAge) {
				System.out.println("Enter Age:");
				try {
					age = Integer.parseInt(reader.readLine());
				} catch (Exception e) {
					System.out.println("Please enter valid age");
				}
				if (age >= 18 && age < 120) {
					flagAge = false;
				} else {
					System.out.println("Age Must be greater than or equals to 18");
				}
			}
			System.out.println("Enter Address");
			String address = reader.readLine();
			int counter = 1;
			String bloodGroup = "";
			while (counter <= 1) {
				System.out.println("Enter blood Group");
				bloodGroup = reader.readLine();
				if (reValidation.bloodGroup(bloodGroup.toUpperCase())) {
					counter = counter + 1;
				} else {
					System.out.println("Please Enter valid Blood Group");
				}
			}
			int counter1 = 1;
			String phoneNumber = "";
			while (counter1 <= 1) {
				System.out.println("Enter Phone Number");
				phoneNumber = reader.readLine();
				if (reValidation.phoneNumber(phoneNumber)) {
					counter1 = counter1 + 1;
				} else {
					System.out.println("Please Enter 10 Digit number & Number Should starts with 7,8 or 9");
				}
			}

			System.out.println("Enter Speciality");
			String speciality = reader.readLine();
			int consultFee = 0;
			while (consultFee <= 0) {
				System.out.println("Enter Consult Fee");
				try {
					consultFee = Integer.parseInt(reader.readLine());
				} catch (NumberFormatException e) {
					System.out.println("Enter valid Consult Fee");

				}
			}
			System.out.println("Enter Department");
			System.out.println(
					"\n Choose any one of the Department\n1.General Physician\n2.CardioLogist \n3.Gynaecologist \n4.Internist\n5.Opthalmologist\n6.Psychiatrist\n7.Orthodontist\n8.Padeiatrician");
			int choice = 0;
			boolean flag = true;
			String department = "";
			while (flag) {
				System.out.println("Enter Choice:");
				try {
					choice = Integer.parseInt(reader.readLine());
				} catch (Exception e) {
					System.out.println("Please enter the Valid Key!!!");
				}
				switch (choice) {
				case 1:
					department = "General Physician";
					flag = false;
					break;
				case 2:
					department = "CardioLogist";
					flag = false;
					break;
				case 3:
					department = "Gynaecologist";
					flag = false;
					break;
				case 4:
					department = "Internist";
					flag = false;
					break;
				case 5:
					department = "Opthalmologist";
					flag = false;
					break;
				case 6:
					department = "Psychiatrist";
					flag = false;
					break;
				case 7:
					department = "Orthodontist";
					flag = false;
					break;
				case 8:
					department = "Padeiatrician";
					flag = false;
					break;
				default:
					System.out.println("Invalid Choice");
					if (choice > 0 && choice < 9) {
						flag = false;
					}
				}
			}
			Doctor doctor = new Doctor(id, password, firstName, lastName, age, address, bloodGroup, phoneNumber,
					speciality, consultFee, department);
			doctors.add(doctor);
			System.out.println("Added Successfully!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// DISPLAY Doctor
	@Override
	public void display() {
		// Print the list objects in tabular format.
		System.out.println("\t\t\t\t\t\t <<<==| DOCTOR DETAILS |==>>>");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %10s %10s %5s %14s %20s %16s %18s %18s %15s, %15s", "DOCTORID", "FIRSTNAME", "LASTNAME",
				"AGE", "ADDRESS", "BLOODGROUP", "PHONE NO.", "SPECIALITY", "CONSULT FEE", "DEPARTMENT", "STATUS");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (Doctor doctor : doctors) {
			System.out.format("%5s %10s %10s %7d %21s %11s %20s %20s %10d %22s %15s", doctor.getId(),
					doctor.getFirstName(), doctor.getLastName(), doctor.getAge(), doctor.getAddress(),
					doctor.getBloodGroup(), doctor.getPhoneNumber(), doctor.getSpeciality(), doctor.getConsultFee(),
					doctor.getDepartment(), doctor.getStatus());
			System.out.println();
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	// UPDATE Doctor
	@Override
	public void update() {
		PrintStream out = System.out;

		System.out.println("Enter doctor id which you want to update:");
		String id = "";
		try {
			id = reader.readLine();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int index = 0;
		boolean check = true;

		for (Doctor d : doctors) {
			int flag = 0;
			if (d.getId().equals(id)) {
				index = flag;
				check = false;
				System.out.println("VALID ID");
			}
			flag++;
		}
		if (check) {
			System.out.println("Invalid ID..\n Try Again");
			try {
				doctorOperations.crud();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}

		int ch = 0;
		do {
			System.out.println("\nWhich One you Want to Update???\n"
					+ "1.Update Firstname\n2.Update Lastname\n3.Update Age\n4.Update Address\n5.Update Blood Group\n6.Update Phone Number\n"
					+ "7.Update Speciality\n8.Update ConsultFee\n9.Update Department\n10.EXIT");
			out.println("Enter choice:");
			try {
				ch = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Invalid choice");
				update();
			}
			String updateStatus = "Updated Successfully!!!";
			switch (ch) {
			case 1:
				String firstName = "";
				int counter2 = 0;
				while (counter2 <= 0) {
					System.out.println("Enter Updated First Name:");
					try {
						firstName = reader.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (reValidation.name(firstName)) {
						++counter2;
					} else {
						System.out.println("Enter Valid First Name & must Start with Capital Letter");
					}
				}
				doctors.get(index).setFirstName(firstName);
				System.out.println(updateStatus);
				break;
			case 2:
				String lastName = "";
				int counter3 = 0;
				while (counter3 <= 0) {
					System.out.println("Enter Updated Last Name");
					try {
						lastName = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (reValidation.name(lastName)) {
						++counter3;
					} else {
						System.out.println("Enter Valid Last Name & must Start with Capital Letters");
					}
				}

				doctors.get(index).setLastName(lastName);
				System.out.println(updateStatus);

				break;
			case 3:
				int age = 0;
				boolean flagAge = true;
				while (flagAge) {
					System.out.println("Enter Age:");
					try {
						age = Integer.parseInt(reader.readLine());
					} catch (Exception e) {
						System.out.println("Please enter valid age");
					}
					if (age >= 18 && age < 120) {
						flagAge = false;
					} else {
						System.out.println("Age Must be greater than 17 and less than 120");
					}
				}
				doctors.get(index).setAge(age);
				System.out.println(updateStatus);

				break;
			case 4:
				try {
					doctors.get(index).setAddress(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(updateStatus);
				break;
			case 5:
				int counter = 1;
				String bloodGroup = "";
				while (counter <= 1) {
					System.out.println("Enter blood Group");
					try {
						bloodGroup = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (reValidation.bloodGroup(bloodGroup.toUpperCase())) {
						counter = counter + 1;
					} else {
						System.out.println("Enter Valid Blood Group");
					}
				}
				doctors.get(index).setBloodGroup(bloodGroup);
				System.out.println(updateStatus);

				break;
			case 6:
				int counter1 = 1;
				String phoneNumber = "";
				while (counter1 <= 1) {
					System.out.println("Enter Phone Number");
					try {
						phoneNumber = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (reValidation.phoneNumber(phoneNumber)) {
						counter1 = counter1 + 1;
					} else {
						System.out.println("Please Enter 10 Digit number and Number Must Starts with 7,8 or 9");
					}
				}

				doctors.get(index).setPhoneNumber(phoneNumber);
				System.out.println(updateStatus);

				break;

			case 7:
				try {
					System.out.println("Enter Updated Speciality");
					doctors.get(index).setSpeciality(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(updateStatus);

				break;
			case 8:
				int consultFee = 0;
				boolean flagFee = true;
				while (flagFee) {
					System.out.println("Enter Consult Fee");
					try {
						consultFee = Integer.parseInt(reader.readLine());
					} catch (Exception e) {
						System.out.println("Enter Valid Consult Fee");
					}
					if (consultFee <= 0) {
						System.out.println("Consult fee must be greater than Zero");
					} else {
						flagFee = false;
					}

				}
				doctors.get(index).setConsultFee(consultFee);
				System.out.println(updateStatus);

				break;

			case 9:
				System.out.println("Enter Updated Department");
				System.out.println(
						"\n Choose any one of the Department\n1.General Physician\n2.CardioLogist \n3.Gynaecologist \n4.Internist\n5.Opthalmologist\n6.Psychiatrist\n7.Orthodontist\n8.Padeiatrician");
				int choice = 0;
				boolean flag = true;
				String department = "";
				while (flag) {
					System.out.println("Enter Choice:");
					try {
						choice = Integer.parseInt(reader.readLine());
					} catch (Exception e) {
						System.out.println("Please enter the Valid Key!!!");
					}
					switch (choice) {
					case 1:
						department = "General Physician";
						flag = false;
						break;
					case 2:
						department = "CardioLogist";
						flag = false;
						break;
					case 3:
						department = "Gynaecologist";
						flag = false;
						break;
					case 4:
						department = "Internist";
						flag = false;
						break;
					case 5:
						department = "Opthalmologist";
						flag = false;
						break;
					case 6:
						department = "Psychiatrist";
						flag = false;
						break;
					case 7:
						department = "Orthodontist";
						flag = false;
						break;
					case 8:
						department = "Padeiatrician";
						flag = false;
						break;
					default:
						System.out.println("Invalid Choice");
						if (choice > 0 && choice < 9) {
							flag = false;
						}
					}
				}
				doctors.get(index).setDepartment(department);
				System.out.println(updateStatus);

				break;
			case 10:
				try {
					doctorOperations.crud();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid Key!!!");
				update();

			}

		} while (ch != 10);

		for (Doctor d : doctors) {
			System.out.println(d);
		}
	}

	// DELETE Doctor
	@Override
	public void delete() {
		System.out.println("Enter id no. to delete");
		try {
			String id = reader.readLine();
			boolean flag = true;
			Iterator<Doctor> it = doctors.iterator();
			while (it.hasNext()) {
				Doctor d = it.next();
				if (d.getId().equals(id)) {
					it.remove();
					flag = false;
					System.out.println("!!!Deleted Successfully!!!");
				}
				if (flag) {
					System.out.println("Invalid ID");

				}
			}

		} catch (NumberFormatException | IOException e) {
			System.out.println("Invalid ID");
		}
	}

	public List<Doctor> getAllDoctors() {
		return doctors;
	}
}

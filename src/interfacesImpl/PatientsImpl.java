package interfacesImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import interfaces.BaseInterface;
import model.Patient;
import services.PatientOperations;
import utility.RegistrationValidation;

public class PatientsImpl implements BaseInterface {

	static List<Patient> patientslist = new ArrayList<Patient>();
	PatientOperations patientOperations = new PatientOperations();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	RegistrationValidation reValidation = new RegistrationValidation();

	// ADD PATIENTS
	@Override
	public void add() {
		try {
			String id = "";
			boolean flags = true;
			do {
				System.out.println("Enter Id:");
				id = reader.readLine();
				if (reValidation.id(id)) {
					if (!getAllPatients().isEmpty()) {
						for (Patient patient : getAllPatients()) {
							if (patient.getId().equalsIgnoreCase(id)) {
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
			while (age <= 0 || age > 120) {
				System.out.println("Enter Age:");
				try {
					age = Integer.parseInt(reader.readLine());
				} catch (Exception e) {
					System.out.println("Please enter valid age");
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
					System.out.println("Please Enter Correct Blood Grpup");
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
					System.out.println("Please Enter 10 Digit number");
				}
			}
			System.out.println("Enter Disease");
			String disease = reader.readLine();
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
					break;
				}
			}

			Patient patient = new Patient(id, firstName, lastName, age, address, bloodGroup, phoneNumber, disease,
					department);
			patientslist.add(patient);
			System.out.println("Added Successfully!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// DISPLAY PATIENTS
	@Override
	public void display() {

		// Print the list objects in tabular format.
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %10s %10s %5s %14s %20s %16s %18s %20s %15s %6s", "PATIENTID", "FIRSTNAME", "LASTNAME",
				"AGE", "ADDRESS", "BLOODGROUP", "PHONE NO.", "DISEASE", "DEPARTMENT", "ROOM NO.", "PAY BILL");
		System.out.println();
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (Patient patient : patientslist) {
			System.out.format("%5s %10s %10s %7d %21s %11s %20s %18s %22s %10s %.02f", patient.getId(),
					patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getAddress(),
					patient.getBloodGroup(), patient.getPhoneNumber(), patient.getDisease(), patient.getDepartment(),
					patient.getRoomNo(), patient.getPayBill());
			System.out.println();
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	// UPDATE PATIENTS
	@Override
	public void update() {
		PrintStream out = System.out;

		System.out.println("Enter patient id which you want to update:");
		String id = "";
		try {
			id = reader.readLine();
		} catch (NumberFormatException e1) {
			System.out.println("Invalid Key");
		} catch (IOException e1) {
			System.out.println("Invalid Key");
		}
		int index = 0;
		for (Patient d : patientslist) {
			int flag = 0;
			if (d.getId().equals(id)) {
				index = flag;
				System.out.println("VALID ID");
			}
			flag++;
		}
		int ch = 0;
		do {
			System.out.println("\n Which One you want to Update??\n"
					+ "1.Update Firstname\n2.Update Lastname\n3.Update Age\n4.Update Address\n5.Update Blood Group\n6.Update Phone Number\n"
					+ "7.Update Disease\n8.Update Department\n9.EXIT");
			out.println("Enter choice:");
			try {
				ch = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String updateStatus = "Updated Successfully!!!\n";
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
				patientslist.get(index).setFirstName(firstName);
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
						e.printStackTrace();
					}
					if (reValidation.name(lastName)) {
						++counter3;
					} else {
						System.out.println("Enter Valid Last Name & must Start with Capital Letters");
					}
				}

				patientslist.get(index).setLastName(lastName);
				System.out.println(updateStatus);

				break;
			case 3:
				int age = 0;
				while (age <= 0 || age > 120) {
					System.out.println("Enter Updated Age:");
					try {
						age = Integer.parseInt(reader.readLine());
					} catch (Exception e) {
						System.out.println("Please enter valid age");
					}
				}
				patientslist.get(index).setAge(age);
				System.out.println(updateStatus);

				break;
			case 4:
				try {
					patientslist.get(index).setAddress(reader.readLine());
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

						e.printStackTrace();
					}
					if (reValidation.bloodGroup(bloodGroup.toUpperCase())) {
						counter = counter + 1;
					} else {
						System.out.println("Enter Valid Blood Group");
					}
				}
				patientslist.get(index).setBloodGroup(bloodGroup);
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
						e.printStackTrace();
					}
					if (reValidation.phoneNumber(phoneNumber)) {
						counter1 = counter1 + 1;
					} else {
						System.out.println("Please Enter 10 Digit number");
					}
				}

				patientslist.get(index).setPhoneNumber(phoneNumber);
				System.out.println(updateStatus);

				break;

			case 7:
				try {
					patientslist.get(index).setDisease(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 8:
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
				patientslist.get(index).setDepartment(department);
				System.out.println(updateStatus);
				break;
			case 9:
				try {
					patientOperations.crud();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid Key!!!");
				update();
				break;
			}

		} while (ch != 9);
		for (Patient d : patientslist) {
			System.out.println(d);
		}

	}

	// DELETE PATIENTS
	@Override
	public void delete() {
		System.out.println("Enter id no. to delete");
		try {
			String id = reader.readLine();
			Iterator<Patient> it = patientslist.iterator();
			boolean flag = true;
			while (it.hasNext()) {
				Patient d = it.next();
				if (d.getId().equals(id)) {
					it.remove();
					flag = false;
					System.out.println("Deleted Successfully");
				}
			}
			if (flag) {
				System.out.println("Invalid ID try Again!! or No Patient Existed");
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	// LIST OF PATIENTS
	public List<Patient> getAllPatients() {
		return patientslist;
	}

}

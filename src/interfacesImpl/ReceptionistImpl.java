package interfacesImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import interfaces.BaseInterface;
import model.Receptionist;
import services.ReceptionistCRUD;
import utility.RegistrationValidation;

public class ReceptionistImpl implements BaseInterface {

	static List<Receptionist> receptionistslist = new ArrayList<Receptionist>();
	ReceptionistCRUD receptionistOperations = new ReceptionistCRUD();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	RegistrationValidation reValidation = new RegistrationValidation();

	// ADD RECEPTIONIST
	@Override
	public void add() {
		try {
			String id = "";
			boolean flags = true;
			do {
				System.out.println("Enter Id:");
				id = reader.readLine();
				if (reValidation.id(id)) {
					if (!getAllreceptionist().isEmpty()) {
						for (Receptionist receptionist : getAllreceptionist()) {
							if (receptionist.getId().equalsIgnoreCase(id)) {
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
			boolean flag = true;
			String password = "";
			while (flag) {
				System.out.println("Enter Password:");
				password = reader.readLine();
				if (reValidation.validPassword(password)) {
					flag = false;
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
			Receptionist receptionist = new Receptionist(id, password, firstName, lastName, age, address, bloodGroup,
					phoneNumber);
			receptionistslist.add(receptionist);
			System.out.println("Added Successfully!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// DISPLAY Receptionist
	@Override
	public void display() {
		// Print the list objects in tabular format.
		System.out.println("\t\t\t\t\t <<<==| RECEPTIONIST DETAILS |==>>>");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %10s %10s %10s %5s %14s %20s %16s", "RECPID", "PASSWORD", "FIRSTNAME", "LASTNAME", "AGE",
				"ADDRESS", "BLOODGROUP", "PHONE NO.");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------");
		for (Receptionist receptionist : receptionistslist) {
			System.out.format("%5s %10s %10s %10s %7d %21s %11s %20s", receptionist.getId(), receptionist.getPassword(),
					receptionist.getFirstName(), receptionist.getLastName(), receptionist.getAge(),
					receptionist.getAddress(), receptionist.getBloodGroup(), receptionist.getPhoneNumber());
			System.out.println();
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------");

	}

	// UPDATE RECEPTIONIST
	@Override
	public void update() {
		PrintStream out = System.out;

		System.out.println("Enter receptionist id which you want to update:");
		String id = "";
		try {
			id = reader.readLine();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean check = true;

		int index = 0;
		for (Receptionist d : receptionistslist) {
			int flag = 0;
			if (d.getId().equals(id)) {
				index = flag;
				check = false;
				System.out.println("Valid id");
			}
			flag++;
		}
		if (check) {
			System.out.println("Invalid ID..\n Try Again");
			try {
				receptionistOperations.crud();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}

		int ch = 0;
		do {
			System.out.println("Which one you want to Update??"
					+ "\n1.Update Firstname\n2.Update Lastname\n3.Update Age\n4.Update Address\n5.Update Blood Group\n6.Update Phone Number\n7.EXIT");
			out.println("Enter choice:");
			try {
				ch = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Invalid Choice!!");
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
				receptionistslist.get(index).setFirstName(firstName);
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

				receptionistslist.get(index).setLastName(lastName);
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
				receptionistslist.get(index).setAge(age);
				System.out.println(updateStatus);

				break;
			case 4:
				try {
					receptionistslist.get(index).setAddress(reader.readLine());
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
					}
				}
				receptionistslist.get(index).setBloodGroup(bloodGroup);
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
						System.out.println("Please Enter 10 Digit number");
					}
				}

				receptionistslist.get(index).setPhoneNumber(phoneNumber);
				System.out.println(updateStatus);

				break;
			case 7:
				try {
					receptionistOperations.crud();
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid Key!!!");
				update();
			}

		} while (ch != 7);
		System.out.println("UPDATED SUCCESSFULLY!!!");
		for (Receptionist d : receptionistslist) {
			System.out.println(d);
		}

	}

	// DELETE RECEPTIONIST
	@Override
	public void delete() {
		System.out.println("Enter id no. to delete");
		try {
			String id = reader.readLine();
			Iterator<Receptionist> it = receptionistslist.iterator();
			boolean flag = true;
			while (it.hasNext()) {
				Receptionist d = it.next();
				if (d.getId().equals(id)) {
					it.remove();
					flag = false;
					System.out.println("DELETED SUCCESSFULLY!!!");
				}
			}
			if (flag) {
				System.out.println("Invalid ID");
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	// LIST OF RECEPTIONIS
	public List<Receptionist> getAllreceptionist() {
		return receptionistslist;
	}
}

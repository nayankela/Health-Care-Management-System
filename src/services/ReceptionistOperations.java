package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import controller.MainApp;
import interfacesImpl.DoctorImpl;
import interfacesImpl.PatientsImpl;
import interfacesImpl.ReceptionistImpl;
import interfacesImpl.RoomsImpl;
import model.Doctor;
import model.Patient;
import model.Receptionist;
import model.Rooms;
import utility.RegistrationValidation;

public class ReceptionistOperations {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	MainApp main = new MainApp();
	DoctorImpl doctorImpl = new DoctorImpl();
	List<Doctor> doctors = doctorImpl.getAllDoctors();
	RoomsImpl impl = new RoomsImpl();
	List<Rooms> roomsList = impl.getAllRooms();
	PatientsImpl patientsImpl = new PatientsImpl();
	List<Patient> pList = patientsImpl.getAllPatients();
	final double roomPrize = 1500;
	RegistrationValidation reValidation = new RegistrationValidation();

	// RECEPTIONIST LOGIN
	public void receptionistLogin() throws IOException {
		ReceptionistImpl receptionistImpl = new ReceptionistImpl();
		List<Receptionist> recep = receptionistImpl.getAllreceptionist();
		System.out.println("\t\t\tEnter your id: ");
		String id = reader.readLine();
		System.out.println("\t\t\tEnter your Password: ");
		String password = reader.readLine();
		boolean flag = true;
		for (int i = 0; i < recep.size(); i++) {
			if (recep.get(i).getId().equalsIgnoreCase(id) && recep.get(i).getPassword().equalsIgnoreCase(password)) {
				System.out.println("\t\t\tLogin Success!!");
				receptionistMenu();
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Acess Denied..\n Invalid Credentials");
			main.start();
		}

	}

	// RECEPTIONIST MENU
	public void receptionistMenu() throws NumberFormatException, IOException {
		System.out.println(
				"\t\t\t\tWELCOME TO RECEPTIONIST PORTAL\n\t\t\t-------------------------------------------\n\t\t\t\t__________________\n\t\t\t\t RECEPTIONIST MENU \n\t\t\t\t__________________");
		int choice = 0;
		do {
			System.out.println(
					"\n\t\t\t\t 1.Doctor's Availability\n\t\t\t\t 2.Change Doctor's Availability\n\t\t\t\t 3.Rooms Availability\n\t\t\t\t 4.Patients CRUD\n\t\t\t\t 5.List of Patients \n\t\t\t\t 6.Allocate Room to Patients\n\t\t\t\t 7.Give Appointment \n\t\t\t\t 8.Exit");
			System.out.println("\n\t\t\t\tEnter Choice:");
			try {
				choice = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Invalid Key!!!");
			}
			switch (choice) {
			case 1:
				getAllDoctorAvailibilityList();
				break;
			case 2:
				getAllDoctorListandMarktheStatus();

				break;
			case 3:
				roomsAvailabilityCheck();
				break;
			case 4:
				PatientOperations operations = new PatientOperations();
				operations.crud();
				break;
			case 5:
				listOfAllPatients();
				break;
			case 6:
				allocateRoomToPatients();
				break;
			case 7:
				takeAppointment();
				break;
			case 8:
				main.start();
				break;
			default:
				receptionistMenu();
				break;
			}
		} while (choice != 8);
	}

	String available = "Available";
	String notAvailable = "Not Available";

	// CHANGE DOCTOR'S AVAILABILITY
	public void getAllDoctorListandMarktheStatus() throws IOException {

		System.out.println("\t\t\tEnter the Doctor ID");
		String id = reader.readLine();
		System.out.println(
				"\n\t\t\tChange Status\n\t\t\t_____________ \n\t\t\t1.Available\n\t\t\t2.Not Available\n\t\t\t3.Exit");
		int choice = 0;
		try {
			choice = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.out.println("Invalid choice!!!");
		}
		int counter = 0;
		switch (choice) {
		case 1:
			for (int i = 0; i < doctors.size(); i++) {
				if (doctors.get(i).getId().equalsIgnoreCase(id)) {
					doctors.get(i).setStatus(available);
					counter = counter + 1;
					System.out.println("Updated Successfully!!!");
				}
			}

			break;
		case 2:
			for (int i = 0; i < doctors.size(); i++) {
				if (doctors.get(i).getId().equalsIgnoreCase(id)) {
					doctors.get(i).setStatus(notAvailable);
					counter = counter + 1;
					System.out.println("Updated Successfully!!!");

				}
			}
			break;
		case 3:
			receptionistMenu();
			break;
		default:
			System.out.println("Invalid key");
			receptionistMenu();
			break;
		}

		if (counter == 0) {
			System.out.println("Invalid ID");
		}

	}

	int counter1 = 0;

	// CHECK DOCTOR'S AVAILABILITY
	public void getAllDoctorAvailibilityList() throws IOException {
		List<Doctor> doctorsAvailability = new ArrayList<Doctor>();

		for (int i = 0; i < doctors.size(); i++) {
			if (doctors.get(i).getStatus().equals(available)) {
				doctorsAvailability.add(doctors.get(i));
			}
		}

		// Print the list objects in tabular format.
		System.out.println("\t\t\t\t\t <<<==| DOCTOR AVAILABILITY DETAILS |==>>>");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %10s %10s %5s %14s %20s %16s %18s %18s %15s, %15s", "DOCTORID", "FIRSTNAME", "LASTNAME",
				"AGE", "ADDRESS", "BLOODGROUP", "PHONE NO.", "SPECIALITY", "CONSULT FEE", "DEPARTMENT", "STATUS");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (Doctor doctor : doctorsAvailability) {
			System.out.format("%5s %10s %10s %7d %21s %11s %20s %20s %10d %22s %15s", doctor.getId(),
					doctor.getFirstName(), doctor.getLastName(), doctor.getAge(), doctor.getAddress(),
					doctor.getBloodGroup(), doctor.getPhoneNumber(), doctor.getSpeciality(), doctor.getConsultFee(),
					doctor.getDepartment(), doctor.getStatus());
			System.out.println();
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	// LIST OF PATIENTS
	public void listOfAllPatients() {
		// System.out.println(pList);
		// Print the list objects in tabular format.
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %10s %10s %5s %14s %20s %16s %18s %20s %15s %6s", "PATIENTID", "FIRSTNAME", "LASTNAME",
				"AGE", "ADDRESS", "BLOODGROUP", "PHONE NO.", "DISEASE", "DEPARTMENT", "ROOM NO.", "PAY BILL");
		System.out.println();
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (Patient patient : pList) {
			System.out.format("%5s %10s %10s %7d %21s %11s %20s %18s %22s %10s %.02f", patient.getId(),
					patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getAddress(),
					patient.getBloodGroup(), patient.getPhoneNumber(), patient.getDisease(), patient.getDepartment(),
					patient.getRoomNo(), patient.getPayBill());
			System.out.println();
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	// ALLOCATE ROOMS TO PATIENTS
	public void allocateRoomToPatients() throws IOException {

		System.out.println("Enter Patient ID");
		String id = reader.readLine();
		int days = 0;
		boolean flag1 = true;
		while (flag1) {
			System.out.println("Enter Number of Days ");
			try {
				days = Integer.parseInt(reader.readLine());
				flag1 = false;
			} catch (Exception e) {
				System.out.println("Invalid Key!!!");
				receptionistMenu();
			}
		}
		// boolean flag = true;
		int counter = 0;
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getId().equalsIgnoreCase(id)) {
				++counter;
				if ((pList.get(i).getRoomNo() == null)) {
					++counter;
					pList.get(i).setRoomNo(roomsList.get(0));
					System.out.println(" ROOM NO. " + roomsList.get(0) + " ALLOTED SUCCESSFULLY!!!");
					roomsList.remove(0);
					double bill = roomPrize * days;
					System.out.println("TOTAL ROOM FEE TO BE PAID: " + bill);
					if (pList.get(i).getPayBill() != 0) {
						pList.get(i).setPayBill(pList.get(i).getPayBill() + bill);
					} else {
						pList.get(i).setPayBill(bill);
					}
					// flag = false;
				}
			}
		}
		if (counter == 1) {
			System.out.println("PATIENTS ALREADY ALLOTED ROOM");
		} else if (counter == 0) {
			System.out.println("THIS PATIENT NOT REGISTERED YET");
		}
	}

	static int counter = 0;

	// ROOM AVAILABILITY CHECK
	public void roomsAvailabilityCheck() {

		// System.out.println(roomsList);
		// Print the list objects in tabular format.
		System.out.println("---------------------");
		System.out.printf("%10s", "ROOM ID");
		System.out.println();
		System.out.println("---------------------");
		for (Rooms room : roomsList) {
			System.out.format("%10d", room.getRoomNo());
			System.out.println();
		}
		System.out.println("---------------------");

	}

	static List<Patient> appointments = new ArrayList<Patient>();

	// TAKE APPOINTMENTS
	public void takeAppointment() throws IOException {
		// System.out.println(doctors);
		// System.out.println(pList);
		System.out.println("Enter Patient ID");
		String id = reader.readLine();
		double counsultFee = 0;
		boolean flag = true;
		int counter = 1;
		for (int i = 0; i < pList.size(); i++) {
			for (int j = 0; j < doctors.size(); j++) {
				if (pList.get(i).getId().equals(id)) {
					++counter;
					if (pList.get(i).getDepartment().equalsIgnoreCase(doctors.get(j).getDepartment())) {
						counsultFee = doctors.get(j).getConsultFee();
						appointments.add(pList.get(i));
						System.out.println(pList.get(i).getFirstName() + " " + pList.get(i).getLastName()
								+ " WITH PATIENT ID " + pList.get(i).getId() + " HAVE APPOINTMENT WITH DOCTOR "
								+ doctors.get(j).getFirstName() + " " + doctors.get(j).getLastName());
						System.out.println("CONSULT FEE TO BE PAID: " + counsultFee);
						if (pList.get(i).getPayBill() != 0) {
							pList.get(i).setPayBill(pList.get(i).getPayBill() + counsultFee);
						} else {
							pList.get(i).setPayBill(counsultFee);
						}
						flag = false;
						break;
					}
				}
			}
		}
		if (counter == 1) {
			System.out.println("Invalid patient ID");
		} else if (flag) {
			System.out.println("THIS DEPARTMENT DOCTOR'S NOT AVAILABLE TODAY");
		}
	}

	// GET ALL APPOINTMENT PATIENTS
	public List<Patient> getAllAppointments() {
		return appointments;
	}
}
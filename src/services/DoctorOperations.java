package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.MainApp;
import interfacesImpl.DoctorImpl;
import model.Doctor;
import model.Patient;

public class DoctorOperations {

	MainApp app = new MainApp();
	DoctorImpl doctorImpl = new DoctorImpl();
	List<Doctor> doctors = doctorImpl.getAllDoctors();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ReceptionistOperations operations = new ReceptionistOperations();
	String id = "";

	public void doctorLogin() throws IOException {
		System.out
				.println("\n\t\t\t______________________________\n\t\t\t\tLogin\n\t\t\t______________________________");
		System.out.println("\n\t\t\tEnter the Doctor ID: ");
		id = reader.readLine();
		System.out.println("\n\t\t\tEnter Password: ");
		String password = reader.readLine();
		boolean flag = true;
		for (int i = 0; i < doctors.size(); i++) {
			if (doctors.get(i).getId().equalsIgnoreCase(id) && doctors.get(i).getPassword().equals(password)) {
				System.out.println("Login Success!!");
				flag = false;
				doctorMenu();
			}
		}
		if (flag) {
			System.out.println("\n\t\t\t...Access Denied...\n\t\t\t Invalid Credentials\n\t\t\t Try Again....");
			app.start();
		}
	}

	public void doctorMenu() throws NumberFormatException, IOException {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		boolean flag = true;
		while (flag) {
			System.out.println("\n\t\t___________________________________________________________________________"
					+ "\n\t\t\t\t Welcome to Doctor's DashBoard\n\t\t___________________________________________________________________________\n\t\t\t \n\t\t\t-------------------------------------\n\t\t\t\tDoctor's Menu\n\t\t\t-------------------------------------\n");
			System.out.println(
					"\n\t\t\t 1.Doctor's Availability\n\t\t\t 2.Change your Availability\n\t\t\t 3.List of Patient's Appointment\n\t\t\t 4.Exit\n");
			System.out.println("Enter choice:");
			int choice = 0;
			try {
				choice = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Invalid Key!!");
			}
			switch (choice) {
			case 1:
				operations.getAllDoctorAvailibilityList();
				break;
			case 2:
				operations.getAllDoctorListandMarktheStatus();
				break;
			case 3:
				getAllAppointedPatients();
				break;
			case 4:
				flag = false;
				app.start();
				break;
			default:
				doctorMenu();
				break;
			}

		}
	}

	List<Patient> appointments = operations.getAllAppointments();

	public void getAllAppointedPatients() {

		// Print the list objects in tabular format.
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %10s %10s %5s %14s %20s %16s %18s %20s %15s %6s", "PATIENTID", "FIRSTNAME", "LASTNAME",
				"AGE", "ADDRESS", "BLOODGROUP", "PHONE NO.", "DISEASE", "DEPARTMENT", "ROOM NO.", "PAY BILL");
		System.out.println();
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < doctors.size(); i++) {
			for (int j = 0; j < appointments.size(); j++)
				if (appointments.get(j).getDepartment().equalsIgnoreCase(doctors.get(i).getDepartment())
						&& doctors.get(i).getId().equalsIgnoreCase(id)) {
					// System.out.println(appointments.get(j));
					System.out.format("%5s %10s %10s %7d %21s %11s %20s %18s %22s %7s %.02f",
							appointments.get(j).getId(), appointments.get(j).getFirstName(),
							appointments.get(j).getLastName(), appointments.get(j).getAge(),
							appointments.get(j).getAddress(), appointments.get(j).getBloodGroup(),
							appointments.get(j).getPhoneNumber(), appointments.get(j).getDisease(),
							appointments.get(j).getDepartment(), appointments.get(j).getRoomNo(),
							appointments.get(j).getPayBill());
					System.out.println();

				}

		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}
}

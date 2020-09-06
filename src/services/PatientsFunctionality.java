package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.MainApp;
import interfacesImpl.PatientsImpl;
import model.Patient;

public class PatientsFunctionality {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	MainApp main = new MainApp();
	ReceptionistOperations receptionistOperations = new ReceptionistOperations();

	public void patientsLogin() throws IOException {
		PatientsImpl patientsImpl = new PatientsImpl();
		List<Patient> recep = patientsImpl.getAllPatients();
		System.out.println("\t\t\tEnter your id: ");
		String id = reader.readLine();
		boolean flag = true;
		for (int i = 0; i < recep.size(); i++) {
			if (recep.get(i).getId().equalsIgnoreCase(id)) {
				System.out.println("\t\t\tLogin Success!!");
				patientMenu();
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Acess Denied..\n Invalid Credentials");
			main.start();
		}

	}

	private void patientMenu() throws NumberFormatException, IOException {
		boolean flag = true;
		while (flag) {
			System.out.println(
					"\n\t\t\t----------------------------------------------\n\t\t\t\tWELCOME TO PATIENT'S DASHBOARD\n\t\t\t----------------------------------------------\n\t\t\t\t_______________\n\t\t\t\t PATIENT'S MENU \n\t\t\t\t_______________");

			System.out.println("1.Doctors Availability\n2.Beds Availability\n3.Take Appointment\n4.Book Bed\n5.Exit\n");
			int choice = 0;
			System.out.println("Enter choice:");
			try {
				choice = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Invalid Key!!!");
			}

			switch (choice) {
			case 1:
				receptionistOperations.getAllDoctorAvailibilityList();
				break;
			case 2:
				receptionistOperations.roomsAvailabilityCheck();
				break;
			case 3:
				receptionistOperations.takeAppointment();
				break;
			case 4:
				receptionistOperations.allocateRoomToPatients();
				break;
			case 5:
				main.start();
				break;
			default:
				if (choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5) {
					flag = false;
					main.start();
				}
				break;

			}
		}
	}
}

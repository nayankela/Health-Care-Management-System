package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.MainApp;
import utility.ValidateAdmin;

public class AdminOperations {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	MainApp main = new MainApp();

	public void adminLogin() throws IOException {
		System.out.println("\t\t\tEnter your id: ");
		String id = reader.readLine();
		System.out.println("\t\t\tEnter your Password: ");
		String password = reader.readLine();
		ValidateAdmin admin = new ValidateAdmin();
		if (admin.validate(id, password)) {
			System.out.println("Login Success..\n\n");
			adminMenu();
		} else {
			System.out.println("Acess Denied..\n Invalid Credentials");
			main.start();
		}
	}

	public void adminMenu() throws NumberFormatException, IOException {
		System.out.println(
				"\t\t\tWELCOME TO ADMIN DASHBOARD\n\t\t--------------------------------------\n\t\t\t\t____________\n\t\t\t\t ADMIN MENU \n\t\t\t\t____________");
		System.out.println("\n\t\t\t\t 1.Doctor\n\t\t\t\t 2.Receptionist\n\t\t\t\t 3.Rooms\n\t\t\t\t 4.Exit");
		System.out.println("\n\t\t\t\tEnter Choice:");
		int choice = 0;
		try {
		 choice = Integer.parseInt(reader.readLine());
		}catch (Exception e) {
			System.out.println("Please Enter the valid Key");
		}
		switch (choice) {
		case 1:
			DoctorCRUD doctorOperations = new DoctorCRUD();
			doctorOperations.crud();
			break;
		case 2:
			ReceptionistCRUD receptionistOperations = new ReceptionistCRUD();
			receptionistOperations.crud();
			break;
		case 3:
			RoomsCRUD roomsOperations = new RoomsCRUD();
			roomsOperations.crud();
			break;
		case 4:
			main.start();
			break;
		default:
			System.out.println("Invalid key");
			adminMenu();
			break;
		}

	}
}

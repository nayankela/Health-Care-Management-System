package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.MainApp;
import utility.ValidateAdmin;

public class ExcelGenerationOperations {

	MainApp mainApp = new MainApp();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public void adminLogin() throws IOException {
		System.out.println("\t\t\tEnter your id: ");
		String id = reader.readLine();
		System.out.println("\t\t\tEnter your Password: ");
		String password = reader.readLine();
		ValidateAdmin admin = new ValidateAdmin();
		if (admin.validate(id, password)) {
			System.out.println("Login Success..\n\n");
			excelOperations();
		} else {
			System.out.println("Acess Denied..\n Invalid Credentials");
			mainApp.start();
		}
	}

	public void excelOperations() throws NumberFormatException, IOException {
		ExcelGeneration excelGeneration = new ExcelGeneration();

		System.out.println("\n\t\t\t <<<<<<<<===| EXCEL GENERATOR |===>>>>>>>> ");
		boolean flag = true;
		while (flag) {
			System.out.println(
					"\n\t\t\t\t-------------------------\n\t\t\t\t\tEXCEL-MENU\n\t\t\t\t-------------------------\n\t\t\t__________________________________________ \n\n\t\t\t\t 1.Generate Excel for DOCTOR \n\t\t\t\t 2.Generate Excel for RECEPTIONIST\n\t\t\t\t 3.Generate Excel for PATIENTS \n\t\t\t\t 4.Exit\n\n\t\t\t__________________________________________\n\t\t\t Enter Choice:");
			int choice = 0;
			try {
				choice = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Please enter the valid Key!!!");
			}
			switch (choice) {
			case 1:
				excelGeneration.excelGenerationForDoctors();
				break;
			case 2:
				excelGeneration.excelGenerationForReceptionists();
				break;
			case 3:
				excelGeneration.excelGenerationForPatients();
				break;
			case 4:
				mainApp.start();
				break;
			default:
				if (choice != 1 || choice != 2 || choice != 3 || choice != 4) {
					flag = false;
					excelOperations();
				}
				break;
			}

		}
	}
}

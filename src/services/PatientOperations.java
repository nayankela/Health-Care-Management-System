package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import interfacesImpl.PatientsImpl;

public class PatientOperations {

	public void crud() throws NumberFormatException, IOException {
		ReceptionistOperations receptionistOperations = new ReceptionistOperations();
		PatientsImpl patientsImpl = new PatientsImpl();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = true;
		while (flag) {
			System.out.println(
					"\n\t\t\t----------------------------------------------\n\t\t\t\tWELCOME TO PATIENT'S DASHBOARD\n\t\t\t----------------------------------------------\n\t\t\t\t_______________\n\t\t\t\t PATIENT'S MENU \n\t\t\t\t_______________"
							+ "\n\t\t\t\t 1. ADD PATIENTS \n\t\t\t\t 2. UPDATE PATIENTS\n\t\t\t\t 3. DELETE PATIENTS \n\t\t\t\t 4. DISPLAY PATIENTS\n\t\t\t\t 5. Exit \n\t\t\t\t Enter Choice:");
			int choice = 0;
			try {
			 choice = Integer.parseInt(reader.readLine());
			}catch (Exception e) {
				System.out.println("Invalid Choice!!!");
			}
			switch (choice) {
			case 1:
				patientsImpl.add();
				break;
			case 2:
				patientsImpl.update();
				break;
			case 3:
				patientsImpl.delete();

				break;
			case 4:
				patientsImpl.display();
				break;
			case 5:
				receptionistOperations.receptionistMenu();
				break;
			default:
				if (choice != 1 || choice != 2 || choice != 3 || choice != 4) {
					flag = false;
					receptionistOperations.receptionistMenu();
				}
				break;
			}

		}

	}
}

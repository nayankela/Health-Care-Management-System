package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import interfacesImpl.ReceptionistImpl;

public class ReceptionistCRUD {
	public void crud() throws NumberFormatException, IOException {
		AdminOperations adminOperations = new AdminOperations();
		ReceptionistImpl receptionistImpl = new ReceptionistImpl();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = true;
		int choice = 0;
		while (flag) {
			System.out.println(
					" 1. ADD RECEPTIONIST \n 2. UPDATE RECEPTIONIST \n 3. DELETE RECEPTIONIST \n 4. DISPLAY RECEPTIONIST \n 5. Exit");
			try {
			 choice = Integer.parseInt(reader.readLine());
			}catch (Exception e) {
				System.out.println("Invalid Key");
			}
			switch (choice) {
			case 1:
				receptionistImpl.add();
				break;
			case 2:
				receptionistImpl.update();
				break;
			case 3:
				receptionistImpl.delete();
				
				break;
			case 4:
				receptionistImpl.display();
				break;
			case 5:
				adminOperations.adminMenu();
				break;
			default:
				System.out.println("Invalid Choice!!!");
				if (choice != 1 || choice != 2 || choice != 3 || choice != 4) {
					flag = false;
					adminOperations.adminMenu();
				}
				break;
			}

		}

	}

}

package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import interfacesImpl.DoctorImpl;

public class DoctorCRUD {

	public void crud() throws NumberFormatException, IOException {
		DoctorImpl doctorImpl = new DoctorImpl();
		AdminOperations adminOperations = new AdminOperations();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = true;
		while (flag) {
			System.out.println(" 1.ADD DOCTOR \n 2.UPDATE DOCTOR\n 3.DELETE DOCTOR \n 4.DISPLAY DOCTOR\n 5.Exit");
			int choice = 0;
			try {
			 choice = Integer.parseInt(reader.readLine());
			}catch (Exception e) {
				System.out.println("Please enter the valid Key!!!");
			}
			switch (choice) {
			case 1:
				doctorImpl.add();
				break;
			case 2:
				doctorImpl.update();
				break;
			case 3:
				doctorImpl.delete();
				break;
			case 4:
				doctorImpl.display();
				break;
			case 5:
				adminOperations.adminMenu();
				break;
			default:
				if (choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5) {
					flag = false;
					adminOperations.adminMenu();
				}
				break;
			}

		}
	}
}

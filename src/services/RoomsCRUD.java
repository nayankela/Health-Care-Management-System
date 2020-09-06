package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import interfacesImpl.RoomsImpl;

public class RoomsCRUD {

	public void crud() throws NumberFormatException, IOException {
		AdminOperations adminOperations = new AdminOperations();
		RoomsImpl roomsImpl = new RoomsImpl();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = true;
		while (flag) {
			System.out.println(" 1. ADD ROOMS \n 2. UPDATE ROOMS\n 3. DELETE ROOMS \n 4. DISPLAY ROOMS\n 5. Exit\n");
			int choice = 0;
			try {
				choice = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Invalid Key!!!");
			}
			switch (choice) {
			case 1:
				roomsImpl.add();
				break;
			case 2:
				roomsImpl.update();
				break;
			case 3:
				roomsImpl.delete();
				break;
			case 4:
				roomsImpl.display();
				break;
			case 5:
				adminOperations.adminMenu();
				break;
			default:
				System.out.println("Invalid Choice");
				if (choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5) {
					flag = false;
					adminOperations.adminMenu();
				}
				break;
			}

		}

	}

}

package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import services.AdminOperations;
import services.DoctorOperations;
import services.ExcelGenerationOperations;
import services.PatientsFunctionality;
import services.ReceptionistOperations;

public class MainApp {
	public void start() throws IOException {
		System.out.println("\t\t\t\t\t\t\t----------");
		System.out.println("\t\t\t\t\t\t\t MAIN-MENU");
		System.out.println("\t\t\t\t\t\t\t----------\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("\t\t\t\t\t____________________________________________________");
		System.out.println(
				"\t\t\t\t\t\t\t 1.Admin\n\t\t\t\t\t\t\t 2.Receptionist\n\t\t\t\t\t\t\t 3.Patient\n\t\t\t\t\t\t\t 4.Doctor\n\t\t\t\t\t\t\t 5.Generate Excel\n\t\t\t\t\t\t\t 6.Exit");
		System.out.println("\t\t\t\t\t____________________________________________________\n");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\t\t\t\t\tEnter Choice:");
		int choice = 0;
		try {
			choice = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.out.println("Please enter Valid key");
		}
		switch (choice) {
		case 1:
			AdminOperations adminOperations = new AdminOperations();
			adminOperations.adminLogin();
			break;
		case 2:
			ReceptionistOperations receptionistOperations = new ReceptionistOperations();
			receptionistOperations.receptionistLogin();
			break;
		case 3:
			PatientsFunctionality patientsFunctionality = new PatientsFunctionality();
			patientsFunctionality.patientsLogin();
			break;
		case 4:
			DoctorOperations doctorOperations = new DoctorOperations();
			doctorOperations.doctorLogin();
			break;
		case 5:
			ExcelGenerationOperations excelGenerationOperations = new ExcelGenerationOperations();
			excelGenerationOperations.adminLogin();
			break;
		case 6:
			System.out.println("\n\t\t\t\t======>THANK YOU FOR VISITING<======");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice!!!");
			start();
			break;
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println(
				"\t\t\t*****************************************************************************************");
		for (int i = 0; i < 4; i++) {
			System.out.println("\t\t\t* \t\t\t\t\t\t\t\t\t\t\t*");
		}
		System.out.println("\t\t\t*\t\t <<<<<<==|WELCOME! TO HEALTH CARE MANAGEMENT SYSTEM|==>>>>>>\t\t*");
		System.out.println("\t\t\t*\t\t\t __________________________________________\t\t\t*");
		for (int i = 0; i < 4; i++) {
			System.out.println("\t\t\t* \t\t\t\t\t\t\t\t\t\t\t*");
		}
		System.out.println(
				"\t\t\t*****************************************************************************************\n");
		Thread.sleep(2000);
		System.out.println("\t\t\t\t________________________________________________________________________");
		System.out.println("\t\t\t\t\t\t\tHEALTH CARE MANAGEMENT SYSTEM");
		System.out.println("\t\t\t\t________________________________________________________________________\n\n");
		MainApp app = new MainApp();
		app.start();
	}
}
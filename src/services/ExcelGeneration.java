package services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import interfacesImpl.DoctorImpl;
import interfacesImpl.PatientsImpl;
import interfacesImpl.ReceptionistImpl;
import model.Doctor;
import model.Patient;
import model.Receptionist;

public class ExcelGeneration {

	public void excelGenerationForDoctors() throws IOException {
		DoctorImpl doctorImpl = new DoctorImpl();
		List<Doctor> doctorList = doctorImpl.getAllDoctors();
		FileOutputStream fileOut;
		if (!doctorList.isEmpty()) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Doctor's details");
			HSSFRow hrow = sheet.createRow(0);

			hrow.createCell(0).setCellValue("ID");
			hrow.createCell(1).setCellValue("PASSWORD");
			hrow.createCell(2).setCellValue("FIRSTNAME");
			hrow.createCell(3).setCellValue("LASTNAME");
			hrow.createCell(4).setCellValue("AGE");
			hrow.createCell(5).setCellValue("ADDRESS");
			hrow.createCell(6).setCellValue("BLOODGROUP");
			hrow.createCell(7).setCellValue("PHONENUMBER");
			hrow.createCell(8).setCellValue("SPECIALITY");
			hrow.createCell(9).setCellValue("CONSULTFEE");
			hrow.createCell(10).setCellValue("DEPARTMENT");
			int i = 0;
			for (Doctor doctor : doctorList) {
				int j = i + 1;
				HSSFRow hssfRow = sheet.createRow(j);
				hssfRow.createCell(0).setCellValue(doctor.getId());
				hssfRow.createCell(1).setCellValue(doctor.getPassword());
				hssfRow.createCell(2).setCellValue(doctor.getFirstName());
				hssfRow.createCell(3).setCellValue(doctor.getLastName());
				hssfRow.createCell(4).setCellValue(doctor.getAge());
				hssfRow.createCell(5).setCellValue(doctor.getAddress());
				hssfRow.createCell(6).setCellValue(doctor.getBloodGroup());
				hssfRow.createCell(7).setCellValue(doctor.getPhoneNumber());
				hssfRow.createCell(8).setCellValue(doctor.getSpeciality());
				hssfRow.createCell(9).setCellValue(doctor.getConsultFee());
				hssfRow.createCell(10).setCellValue(doctor.getDepartment());
				i++;
			}

			fileOut = new FileOutputStream("E:\\doctor_details.xls");
			workbook.write(fileOut);
			System.out.println("Doctor's Excel Sheet Generated Successfully!!!");
			fileOut.close();
		} else {
			System.out.println(
					"The Doctor List is Empty so No Excel will be Generated\n Please Add the Data in the List");
		}
	}

	public void excelGenerationForPatients() throws IOException {
		PatientsImpl patientsImpl = new PatientsImpl();
		List<Patient> patientsList = patientsImpl.getAllPatients();
		FileOutputStream fileOut;
		if (!patientsList.isEmpty()) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Patient's details");
			HSSFRow hrow = sheet.createRow(0);
			hrow.createCell(0).setCellValue("ID");
			hrow.createCell(1).setCellValue("FIRST NAME");
			hrow.createCell(2).setCellValue("LAST NAME");
			hrow.createCell(3).setCellValue("AGE");
			hrow.createCell(4).setCellValue("ADDRESS");
			hrow.createCell(5).setCellValue("BLOOD GROUP");
			hrow.createCell(6).setCellValue("PHONE NUMBER");
			hrow.createCell(7).setCellValue("DISEASE");
			hrow.createCell(8).setCellValue("DEPARTMENT");

			int i = 0;
			for (Patient patient : patientsList) {
				int j = i + 1;
				HSSFRow hssfRow = sheet.createRow(j);
				hssfRow.createCell(0).setCellValue(patient.getId());
				hssfRow.createCell(1).setCellValue(patient.getFirstName());
				hssfRow.createCell(2).setCellValue(patient.getLastName());
				hssfRow.createCell(3).setCellValue(patient.getAge());
				hssfRow.createCell(4).setCellValue(patient.getAddress());
				hssfRow.createCell(5).setCellValue(patient.getBloodGroup());
				hssfRow.createCell(6).setCellValue(patient.getPhoneNumber());
				hssfRow.createCell(7).setCellValue(patient.getDisease());
				hssfRow.createCell(8).setCellValue(patient.getDepartment());
				i++;
			}

			fileOut = new FileOutputStream("E:\\patient_details.xls");
			workbook.write(fileOut);
			System.out.println("Patient's Excel Sheet Generated Successfully!!!");
			fileOut.close();
		} else {
			System.out.println(
					"The Patients List is Empty so No Excel will be Generated\n Please Add the Data in the List");
		}

	}

	public void excelGenerationForReceptionists() throws IOException {
		ReceptionistImpl receptionstImpl = new ReceptionistImpl();
		List<Receptionist> receptionstList = receptionstImpl.getAllreceptionist();
		FileOutputStream fileOut;
		if (!receptionstList.isEmpty()) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Receptionist's details");
			HSSFRow hrow = sheet.createRow(0);
			hrow.createCell(0).setCellValue("ID");
			hrow.createCell(1).setCellValue("PASSWORD");
			hrow.createCell(2).setCellValue("FIRST NAME");
			hrow.createCell(3).setCellValue("LAST NAME");
			hrow.createCell(4).setCellValue("AGE");
			hrow.createCell(5).setCellValue("ADDRESS");
			hrow.createCell(6).setCellValue("BLOOD GROUP");
			hrow.createCell(7).setCellValue("PHONE NUMBER");
			int i = 0;
			for (Receptionist receptionist : receptionstList) {
				int j = i + 1;
				HSSFRow hssfRow = sheet.createRow(j);
				hssfRow.createCell(0).setCellValue(receptionist.getId());
				hssfRow.createCell(1).setCellValue(receptionist.getPassword());
				hssfRow.createCell(2).setCellValue(receptionist.getFirstName());
				hssfRow.createCell(3).setCellValue(receptionist.getLastName());
				hssfRow.createCell(4).setCellValue(receptionist.getAge());
				hssfRow.createCell(5).setCellValue(receptionist.getAddress());
				hssfRow.createCell(6).setCellValue(receptionist.getBloodGroup());
				hssfRow.createCell(7).setCellValue(receptionist.getPhoneNumber());
				i++;
			}

			fileOut = new FileOutputStream("E:\\receptionist_details.xls");
			workbook.write(fileOut);
			System.out.println("Receptionist's Excel Sheet Generated Successfully!!!");
			fileOut.close();
		} else {
			System.out.println(
					"The Receptionist List is Empty so No Excel will be Generated\n Please Add the Data in the List");
		}

	}
}

package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;
import homework.medicalCenter.storage.Storage;

import java.util.Date;
import java.util.Scanner;

public class StorageDemo implements Commands {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Storage STORAGE = new Storage();


    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("01", "Hasmik", "Harutyunyan", "123456", "gmail", "lor");
        Doctor doctor2 = new Doctor("02", "Anna", "Harutyunyan", "663456", "mail", "gyn");
        Doctor doctor3 = new Doctor("03", "Mane", "Arakelyan", "999956", "mail", "lor");

        STORAGE.add(doctor1);
        STORAGE.add(doctor2);
        STORAGE.add(doctor3);

        Patient patient = new Patient("22", "Poxos", "Poxosyan", "55555", doctor2, new Date());
        STORAGE.add(patient);
        Patient patient1 = new Patient("33", "Ptros", "Poxosyan", "55555", doctor2, new Date());
        STORAGE.add(patient1);
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case EXIT -> isRun = false;
                case ADD_DOCTOR -> addDoctor();
                case SEARCH_DOCTOR_BY_PROFESSION -> searchDoctorByProfession();
                case DELETE_DOCTOR_BY_ID -> deleteDoctorById();
                case CHANGE_DOCTOR_DATA_BY_ID -> changeDoctorDataById();
                case ADD_PATIENT -> addPatient();
                case PRINT_ALL_PATIENTS_BY_DOCTOR -> printAllPatientsByDoctor();
                case PRINT_TODAYS_PATIENTS -> printTodaysPatients();
                case PRINT_ALL_DOCTORS -> printAllDoctors();
                default -> System.out.println("Wrong command!");

            }

        }

    }

    private static void printTodaysPatients() {
        Date date = new Date();
        Patient[] todaysPatients = STORAGE.getTodaysPatients(date);
        if (todaysPatients == null) {
            System.out.println("No registered patients for today");
        } else {
            for (Patient todaysPatient : todaysPatients) {
                System.out.println(todaysPatient);
            }
        }
    }

    private static void printAllPatientsByDoctor() {
        Doctor[] allDoctors = STORAGE.findAllDoctors();
        for (Doctor doctor : allDoctors) {
            System.out.println(doctor);
        }
        System.out.println("Please input doctor's id");
        String id = SCANNER.nextLine();
        Doctor doctor = (Doctor) STORAGE.getById(id);

        Patient[] patientsByDoctor = STORAGE.getPatientsByDoctor(doctor);
        if (patientsByDoctor == null) {
            System.out.println("The doctor has no patients");
        } else {
            for (Patient patient : patientsByDoctor) {
                System.out.println(patient);

            }
        }
    }


    private static void addPatient() {
        Doctor[] allDoctors = STORAGE.findAllDoctors();
        for (Doctor doctor : allDoctors) {
            System.out.println(doctor);
        }
        System.out.println("Please choose a doctor by enter doctor's id");
        String id = SCANNER.nextLine();
        Doctor doctorById = (Doctor) STORAGE.getById(id);
        System.out.println("Please input name, surname,phone number");
        String patientDataStr = SCANNER.nextLine();
        String[] patientData = patientDataStr.split(",");
        Date date = new Date();
        boolean ifRegistered = STORAGE.ifAlreadyRegistered(doctorById, date);
        if (!ifRegistered) {
            Patient patient = new Patient(patientData[0], patientData[1], patientData[2], doctorById, new Date());
            Person addedPatient = STORAGE.add(patient);
            System.out.println("Successfully added");
            System.out.println(addedPatient);
        } else {
            System.out.println("Sorry, that date is already registered.");
        }

    }

    private static void changeDoctorDataById() {
        Doctor[] allDoctors = STORAGE.findAllDoctors();
        for (Doctor doctor : allDoctors) {
            System.out.println(doctor);
        }
        System.out.println("Please input id");
        String id = SCANNER.nextLine();
        Doctor doctorById = (Doctor) STORAGE.getById(id);
        if (doctorById == null) {
            System.out.println("Doctor with " + id + " id does ot exit. Please input correct id from above");
        } else {
            System.out.println("Please input new data except id");
            String doctorNewDataStr = SCANNER.nextLine();
            String[] doctorNewData = doctorNewDataStr.split(",");
            doctorById.setName(doctorNewData[0]);
            doctorById.setSurname(doctorNewData[1]);
            doctorById.setPhoneNumber(doctorNewData[2]);
            doctorById.setEmail(doctorNewData[3]);
            doctorById.setProfession(doctorNewData[4]);
            System.out.println(doctorById);

        }
    }

    private static void printAllDoctors() {
        Doctor[] allDoctors = STORAGE.findAllDoctors();
        for (Doctor doctor : allDoctors) {
            System.out.println(doctor);
        }
    }

    private static void deleteDoctorById() {
        Doctor[] allDoctors = STORAGE.findAllDoctors();
        for (Doctor doctor : allDoctors) {
            System.out.println(doctor);
        }
        System.out.println("Please, choose the id");
        String id = SCANNER.nextLine();
        STORAGE.deleteById(id);
        Doctor[] doctors = STORAGE.findAllDoctors();
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void addDoctor() {
        System.out.println("Please input name, surname, phone number, email and profession");
        String doctorDataStr = SCANNER.nextLine();
        String[] doctorData = doctorDataStr.split(",");
        Doctor doctor = new Doctor(doctorData[0], doctorData[1], doctorData[2], doctorData[3], doctorData[4]);
        Person addedDoctor = STORAGE.add(doctor);
        System.out.println("Successfully added");
        System.out.println(addedDoctor);
    }

    private static void searchDoctorByProfession() {
        System.out.println("Please input profession");
        String profession = SCANNER.nextLine();
        Doctor[] doctors = STORAGE.searchDoctorByProfession(profession);
        if (doctors == null) {
            System.out.println("Doctors with profession" + profession + "don't exist");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor);

            }
        }
    }


}

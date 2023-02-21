package homework.medicalCenter;

public interface Commands {

    String EXIT = "0";
    String ADD_DOCTOR = "1";
    String SEARCH_DOCTOR_BY_PROFESSION = "2";
    String DELETE_DOCTOR_BY_ID = "3";
    String CHANGE_DOCTOR_DATA_BY_ID = "4";
    String ADD_PATIENT = "5";
    String PRINT_ALL_PATIENTS_BY_DOCTOR = "6";
    String PRINT_TODAYS_PATIENTS = "7";
    String PRINT_ALL_DOCTORS = "8";

    static public void printCommands() {
        System.out.println("Please, input " + EXIT + " to exit.");
        System.out.println("Please, input " + ADD_DOCTOR + " to add a doctor.");
        System.out.println("Please, input " + SEARCH_DOCTOR_BY_PROFESSION + " to search doctor by profession.");
        System.out.println("Please, input " + DELETE_DOCTOR_BY_ID + " to delete doctor by id");
        System.out.println("Please, input " + CHANGE_DOCTOR_DATA_BY_ID + " to change doctor data by id");
        System.out.println("Please, input " + ADD_PATIENT + " to add a patient");
        System.out.println("Please, input " + PRINT_ALL_PATIENTS_BY_DOCTOR + " to print all patients by doctor");
        System.out.println("Please, input " + PRINT_TODAYS_PATIENTS + " to print today's patients");
        System.out.println("Please, input " + PRINT_ALL_DOCTORS + " to print all doctors");


    }


}

package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.util.DateUtil;

import java.util.Date;

public class PatientStorage {

    private Patient[] patients = new Patient[10];
    private int size = 0;


    private void extend() {
        if (size == patients.length) {
            Patient[] tmp = new Patient[patients.length * 10];
            System.arraycopy(patients, 0, tmp, 0, size);
            this.patients = tmp;
        }

    }


    public void addPatient(Patient patient) {
        if (size == patients.length) {
            extend();
        }
        patients[size++] = patient;
    }

    public Patient getPatientById(String id) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getId().equals(id)) {
                return patients[i];
            }
        }
        return null;
    }

    public boolean ifAlreadyRegistered(Doctor doctor, Date date) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().equals(doctor) &&
                    DateUtil.dateToString(patients[i].getRegisterDate()).equals(DateUtil.dateToString(date))) {
                return true;
            }
        }
        return false;
    }

    public Patient[] getPatientsByDoctor(Doctor doctor) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().equals(doctor)) {
                count++;
            }
        }
        Patient[] patientArray = new Patient[count];
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().equals(doctor)) {
                patientArray[i] = patients[i];
            }

        }

        if (patientArray.length > 0) {
            return patientArray;
        } else return null;
    }

    public Patient[] getTodaysPatients(Date date) {

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (DateUtil.dateToString(date).equals(DateUtil.dateToString(patients[i].getRegisterDate()))) {
                count++;
            }
        }
        Patient[] todayPatients = new Patient[count];
        for (int i = 0; i < size; i++) {
            if (DateUtil.dateToString(date).equals(DateUtil.dateToString(patients[i].getRegisterDate()))) {
                todayPatients[i] = patients[i];
            }
        }
        if (todayPatients.length > 0) {
            return todayPatients;
        } else return null;
    }

}




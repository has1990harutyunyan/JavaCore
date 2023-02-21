package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;


public class DoctorStorage {

    private Doctor[] doctors = new Doctor[10];
    private int size = 0;


    private void extend() {
        if (size == doctors.length) {
            Doctor[] tmp = new Doctor[doctors.length * 10];
            System.arraycopy(doctors, 0, tmp, 0, size);
            this.doctors = tmp;
        }

    }


    public void addDoctor(Doctor doctor) {
        if (size == doctors.length) {
            extend();
        }
        doctors[size++] = doctor;
    }

    public Doctor[] searchDoctorByProfession(String profession) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().equals(profession)) {
                count++;
            }
        }
        Doctor[] doctorsArray = new Doctor[count];
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().equals(profession)) {
                doctorsArray[i] = doctors[i];
            }
        }
        if (doctorsArray.length > 0) {
            return doctorsArray;
        } else return null;
    }

    public void deleteDoctorById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                doctors[i] = doctors[i + 1];
            }
        }
        size--;
    }

    public Doctor getDoctorById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);

        }
    }

}

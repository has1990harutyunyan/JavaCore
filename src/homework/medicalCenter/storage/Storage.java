package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;
import homework.medicalCenter.util.DateUtil;

import javax.print.Doc;
import java.util.Calendar;
import java.util.Date;

public class Storage {

    Person[] persons = new Person[10];
    int size = 0;

    private void extend() {
        if (size == persons.length) {
            Person[] tmp = new Person[persons.length * 10];
            System.arraycopy(persons, 0, tmp, 0, size);
            this.persons = tmp;
        }

    }

    public void add(Person person) {
        if (size == persons.length) {
            extend();
        }
        persons[size++] = person;
    }


    public Person getById(String id) {
        for (int i = 0; i < size; i++) {
            if (persons[i].getId().equals(id)) {
                return persons[i];
            }
        }
        return null;
    }

    public Doctor[] findAllDoctors() {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor) {
                count++;
            }
        }
        Doctor[] doctors = new Doctor[count];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor doctor) {
                doctors[j] = doctor;
                j++;
            }
        }
        return doctors;
    }


    public Patient[] findAllPatients() {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient) {
                count++;
            }
        }
        Patient[] patients = new Patient[count];
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient) {
                patients[i] = patient;
            }
        }
        return patients;
    }

    public Doctor[] searchDoctorByProfession(String profession) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor doctor) {
                if (doctor.getProfession().equals(profession)) {
                    count++;
                }
            }
        }
        Doctor[] doctors = new Doctor[count];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor doctor) {
                if (doctor.getProfession().equals(profession)) {
                    doctors[j] = (Doctor) persons[i];
                    j++;
                }
            }
        }
        return doctors;


    }

    public void deleteById(String id) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i].getId().equals(id)) {
                index = i;
            }
        }
        for (int i = index; i < size; i++) {
            persons[i] = persons[i + 1];

        }
        this.size--;
    }

    public Patient[] getTodaysPatients(Date date) {

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient) {
                if (DateUtil.getDayOfMonth(patient.getRegisterDate()) == DateUtil.getDayOfMonth(date)) {
                    count++;
                }
            }
        }

        int j = 0;
        Patient[] todayPatients = new Patient[count];


        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient) {
                if (DateUtil.getDayOfMonth(patient.getRegisterDate()) == DateUtil.getDayOfMonth(date)) {
                    todayPatients[j] = patient;
                    j++;
                }
            }
        }
        if (todayPatients.length > 0) {
            return todayPatients;
        } else return null;
    }

    public Patient[] getPatientsByDoctor(Doctor doctor) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient && patient.getDoctor().equals(doctor)) {
                count++;
            }
        }

        Patient[] patientArray = new Patient[count];
        int j = 0;
        for (int i = 0; i < this.size; i++) {
            if (persons[i] instanceof Patient patient && patient.getDoctor().equals(doctor)) {
                patientArray[j] = patient;
                j++;
            }
        }
        if (patientArray.length > 0) {
            return patientArray;
        } else return null;


    }


    public boolean ifAlreadyRegistered(Person person, Date date) {
        Doctor doctor = (Doctor) person;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient) {
                if (patient.getDoctor().equals(doctor) && DateUtil.getTimeOfDay(patient.getRegisterDate()) == DateUtil.getTimeOfDay(date)) {
                    return true;
                }
            }

        }
        return false;
    }

}
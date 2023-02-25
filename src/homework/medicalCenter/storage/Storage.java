package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;
import homework.medicalCenter.util.DateUtil;

import java.util.Date;
import java.util.Arrays;
import java.util.UUID;

public class Storage {

    Person[] persons = new Person[10];
    int size = 0;
    int doctorCount = 0;
    int patientCount = 0;

    private void extend() {
        persons = Arrays.copyOf(persons, persons.length * 10);

    }

    private String uniqueIdGenerator() {
        String idStr = UUID.randomUUID().toString();
        for (int i = 0; i < size; i++) {
            if (persons[i].getId().equals(idStr)) {
                idStr = UUID.randomUUID().toString();
                i = 0;
            }
        }
        return idStr;

    }


    public Person add(Person person) {
        if (size == persons.length) {
            extend();
        }
        if (person instanceof Doctor) {
            doctorCount++;
        } else if (person instanceof Patient) {
            patientCount++;
        }
        person.setId(uniqueIdGenerator());
        persons[size++] = person;
        return person;
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
        Doctor[] doctors = new Doctor[doctorCount];
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

        Patient[] patients = new Patient[patientCount];
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

    public Patient[] getTodayPatients(Date date) {

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient) {
                if (DateUtil.dateToCalendar(patient.getRegisterDate()).compareTo(DateUtil.dateToCalendar(date)) == 0) {
                    count++;
                }
            }
        }

        int j = 0;
        Patient[] todayPatients = new Patient[count];
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient) {
                if (DateUtil.dateToCalendar(patient.getRegisterDate()).compareTo(DateUtil.dateToCalendar(date)) == 0) {
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
                if (patient.getDoctor().equals(doctor) && DateUtil.
                        getTimeOfDay(patient.getRegisterDate()) == DateUtil.getTimeOfDay(date) && DateUtil.getDayOfMonth(patient.getRegisterDate()) ==
                        DateUtil.getDayOfMonth(date)) {
                    return true;
                }
            }

        }
        return false;
    }

}
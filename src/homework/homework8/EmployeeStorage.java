package homework.homework8;

import java.util.ArrayList;

public class EmployeeStorage {
    private Employee[] storage = new Employee[10];
    private int size = -1;

    private void extend() {
        Employee[] newStorage = new Employee[storage.length * 2];
        for (int i = 0; i < storage.length - 1; i++) {
            newStorage[i] = storage[i];
        }
        this.storage = newStorage;
    }

    public boolean ifIdExists(String id) {
        boolean ifExists = false;
        for (int i = 0; i <= size; i++) {
            if (storage[i].getId().equals(id)) {
                ifExists = true;
            }
        }
        return ifExists;
    }

    public void addEmployee(Employee employee) {
        if (size == storage.length) {
            extend();
        } else {
            ++size;
            storage[size] = employee;

        }
    }

    public void printAllEmployees() {
        for (int i = 0; i <= size; i++) {
            System.out.println(storage[i]);
        }
    }

    public Employee searchById(String id) {
        for (int i = 0; i <= size; i++) {
            if (storage[i].getId().equals(id)) {
                return storage[i];
            }
        }
        return null;
    }

    public ArrayList<Employee> searchByCompanyName(String companyName) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            if (storage[i].getCompany().toLowerCase().contains(companyName.toLowerCase())) {
                arrayList.add(storage[i]);
            }
        }
        return arrayList;

    }
}

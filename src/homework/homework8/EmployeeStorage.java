package homework.homework8;

public class EmployeeStorage {
    private Employee storage[] = new Employee[10];
    private int size = -1;

    private void extend() {

    }

    public boolean ifIdExists(String id) {
        if (size < 0)
            return true;
        for (Employee employee : storage) {
            if (employee.getId().equals(id)) {
                return false;
            }
        }
        return true;
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

    public Employee searchByCompanyName(String companyName) {
        for (int i = 0; i <= size; i++) {
            if (storage[i].getCompany().toLowerCase().contains(companyName.toLowerCase())) {
                return storage[i];
            }
        }
        return null;
    }
}

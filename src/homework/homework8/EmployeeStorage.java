package homework.homework8;


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

    public boolean existsById(String id) {
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

    public Employee[] searchByCompanyName(String companyName) {

        Employee[] employees = new Employee[0];
        int i = 0;
        int size = 0;
        int j = 0;
        boolean b = true;
        while (true) {
            if (storage[i] != null && storage[i].getCompany().equalsIgnoreCase(companyName)) {
                size++;
                i++;
                continue;
            }
            if (b) {
                employees = new Employee[size];
                b = false;
            }
            if (storage[j] != null && storage[j].getCompany().equalsIgnoreCase(companyName)) {
                employees[j] = storage[j];
                j++;
            }
            if (j == size) {
                return employees;
            }
        }
    }

    public void printActiveEmployees() {
        for (int i = 0; i <= size; i++) {
            if (storage[i].isActive()) {
                System.out.println(storage[i]);
            }
        }
    }

    public Employee[] searchBySalaryRange(double minSalary, double maxSalary) {

        int size = 0;
        for (int i = 0; i <= this.size; i++) {
            if (storage[i].getSalary() >= minSalary && storage[i].getSalary() <= maxSalary) {
                size++;
            }
        }
        if (size > 0) {
            Employee[] employees = new Employee[size];
            for (int i = 0; i < this.size; i++) {
                if (storage[i].getSalary() >= minSalary && storage[i].getSalary() <= maxSalary) {
                    employees[i] = storage[i];
                }
            }
            return employees;
        } else return null;
    }


}

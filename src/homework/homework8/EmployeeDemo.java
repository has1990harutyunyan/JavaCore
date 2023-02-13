package homework.homework8;


import java.util.Scanner;

public class EmployeeDemo {

    private static final EmployeeStorage EMPLOYEE_STORAGE = new EmployeeStorage();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String input = SCANNER.nextLine();
            switch (input) {
                case "0" -> isRun = false;
                case "1" -> createEmployee();
                case "2" -> printAllEmployees();
                case "3" -> searchEmployeeById();
                case "4" -> searchEmployeeByCompanyName();
                case "5" -> searchEmployeeBySalaryRange();
                case "6" -> updateEmployeePosition();
                case "7" -> printActiveEmployees();
                case "8" -> inactivateEmployee();
                case "9" -> activateEmployee();
                default -> System.out.println("Enter only 0 , 1, 2, 3, 4, 5, 6, 7, 8 or 9");
            }

        }
    }

    static void printCommands() {
        System.out.println("For exiting the program, please, enter 0");
        System.out.println("For adding an employee, please, enter 1");
        System.out.println("For printing all the employees, please, enter 2");
        System.out.println("For finding the employee by id, please, enter 3");
        System.out.println("For finding the employee by company name, please, enter 4");
        System.out.println("For searching employees by salary range, place, enter 5");
        System.out.println("For changing employee's position, please, enter 6");
        System.out.println("For printing only active employees, please, enter 7");
        System.out.println("For inactivating an employee , please, enter 8");
        System.out.println("For activating an employee, please, enter 9");
    }

    static void createEmployee() {
        System.out.println("Please enter the name");
        String name = SCANNER.nextLine();
        System.out.println("Please enter the surname");
        String surname = SCANNER.nextLine();
        System.out.println("Please enter the id");
        String id = SCANNER.nextLine();
        System.out.println("Please enter the salary");
        String salary = SCANNER.nextLine();
        System.out.println("Please enter the company");
        String company = SCANNER.nextLine();
        System.out.println("Please enter the position");
        String position = SCANNER.nextLine();
        Employee employee = new Employee(name, surname, id, Double.parseDouble(salary), company, position);
        employee.setActive(true);
        if (EMPLOYEE_STORAGE.existsById(id)) {
            System.err.println("Employee with such id already exists. ");
        } else {
            EMPLOYEE_STORAGE.addEmployee(employee);
        }
    }


    static void searchEmployeeById() {
        System.out.println("Please, enter the id");
        String employeeId = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.searchById(employeeId);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("No such employee exists.");
        }
    }

    static void searchEmployeeByCompanyName() {
        System.out.println("Please, enter the company name");
        String companyName = SCANNER.nextLine();
        Employee[] employees = EMPLOYEE_STORAGE.searchByCompanyName(companyName);
        if (employees == null) {
            System.out.println("No such employee exists.");
        } else {
            for (Employee employee : employees) {
                if (employee == null) {
                    break;
                } else {
                    System.out.println(employee);
                }
            }
        }
    }

    static void printAllEmployees() {
        EMPLOYEE_STORAGE.printAllEmployees();
    }

    static void printActiveEmployees() {
        EMPLOYEE_STORAGE.printActiveEmployees();
    }

    static void inactivateEmployee() {
        System.out.println("Please, enter employee's id for inactivating.");
        String id = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.inactivateEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with such an id does not exist!");
        } else {
            System.out.println("Successfully inactivated");
            System.out.println(employee);
        }
    }

    static void activateEmployee() {
        System.out.println("Please, enter employee's id for activating.");
        String id = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.activateEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with such an id does not exist!");
        } else {
            System.out.println("Successfully activated");
            System.out.println(employee);
        }
    }

    static void searchEmployeeBySalaryRange() {
        System.out.println("PLease, enter the minimum salary");
        String minSalary = SCANNER.nextLine();
        System.out.println("PLease, enter the maximum salary");
        String maxSalary = SCANNER.nextLine();
        Employee[] employees = EMPLOYEE_STORAGE.searchBySalaryRange(Double.parseDouble(minSalary), Double.parseDouble(maxSalary));
        if (employees == null) {
            System.out.println("Employees with such salary range don't exist");
        } else {
            for (Employee employee : employees) {
                if (employee == null) {
                    break;
                } else {
                    System.out.println(employee);
                }
            }
        }
    }

    static void updateEmployeePosition() {
        System.out.println("Please, enter employee's id for changing position");
        String id = SCANNER.nextLine();
        System.out.println("Please, enter employee's new position");
        String newPosition = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.updateEmployeePositionById(id, newPosition);
        if (employee == null) {
            System.out.println("Employee with such an id does not exist!");
        } else {
            System.out.println("Successfully updated");
            System.out.println(employee);
        }
    }

}

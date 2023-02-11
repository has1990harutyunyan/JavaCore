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
                case "0":
                    isRun = false;
                    break;
                case "1":
                    createEmployee();
                    break;
                case "2":
                    printAllEmployees();
                    break;
                case "3":
                    searchEmployeeById();
                    break;
                case "4":
                    searchEmployeeByCompanyName();
                    break;
                default:
                    System.out.println("Enter only 0 , 1, 2, 3 or 4");
            }

        }
    }

    static void printCommands() {
        System.out.println("For exiting the program, please, enter 0");
        System.out.println("For adding an employee, please, enter 1");
        System.out.println("For printing all the employees, please, enter 2");
        System.out.println("For finding the employee by id, please, enter 3");
        System.out.println("For finding the employee by company name, please, enter 4");
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


}

package homework.homework8;


import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDemo {

    private static final EmployeeStorage storage = new EmployeeStorage();
    private static final Scanner scanner = new Scanner(System.in);


    static void printCommands() {
        System.out.println("For exiting the program, please, enter 0");
        System.out.println("For adding an employee, please, enter 1");
        System.out.println("For printing all the employees, please, enter 2");
        System.out.println("For finding the employee by id, please, enter 3");
        System.out.println("For finding the employee by company name, please, enter 4");
    }

    static void createEmployee() {
        System.out.println("Please enter the name");
        String name = scanner.nextLine();
        System.out.println("Please enter the surname");
        String surname = scanner.nextLine();
        System.out.println("Please enter the id");
        String id = scanner.nextLine();
        System.out.println("Please enter the salary");
        String salary = scanner.nextLine();
        System.out.println("Please enter the company");
        String company = scanner.nextLine();
        System.out.println("Please enter the position");
        String position = scanner.nextLine();
        Employee employee = new Employee(name, surname, id, Double.parseDouble(salary), company, position);
        idVerificationAndAddEmployee(employee.id, employee);

    }

    private static void idVerificationAndAddEmployee(String id, Employee employee) {
        boolean ifExists = storage.ifIdExists(id);
        if (!ifExists) {
            storage.addEmployee(employee);
        } else {
            System.out.println("Employee with such id already exists. ");
        }

    }


    static void searchEmployeeById() {
        System.out.println("Please, enter the id");
        String employeeId = scanner.nextLine();
        Employee employee = storage.searchById(employeeId);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("No such employee exists.");
        }
    }

    static void searchEmployeeByCompanyName() {
        System.out.println("Please, enter the company name");
        String companyName = scanner.nextLine();
        ArrayList<Employee> employees = storage.searchByCompanyName(companyName);
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("No such employee exists.");
        }
    }

    static void printAllEmployees() {
        storage.printAllEmployees();
    }


    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String input = scanner.nextLine();
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
}

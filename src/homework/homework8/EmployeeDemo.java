package homework.homework8;

import javax.swing.*;
import java.util.Scanner;

public class EmployeeDemo {

    private static final EmployeeStorage storage = new EmployeeStorage();
    private static final Scanner scanner = new Scanner(System.in);

    private static void foundEmployee(Employee employee) {
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("No such employee exists.");
        }
    }

    private static void idVerificationAndAddEmployee(String id, Employee employee) {
        boolean ifExists = storage.ifIdExists(id);
        if (ifExists) {
            storage.addEmployee(employee);
        } else {
            System.out.println("Employee with such id already exists. ");
        }

    }

    private static void printCommands() {
        System.out.println("For exiting the program, please, enter 0");
        System.out.println("For adding an employee, please, enter 1");
        System.out.println("For printing all the employees, please, enter 2");
        System.out.println("For finding the employee by id, please, enter 3");
        System.out.println("For finding the employee by company name, please, enter 4");
    }

    private static Employee createEmployee() {
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
        return new Employee(name, surname, id, Double.parseDouble(salary), company, position);

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
                    Employee createdEmployee = createEmployee();
                    idVerificationAndAddEmployee(createdEmployee.id, createdEmployee);
                    break;
                case "2":
                    storage.printAllEmployees();
                    break;
                case "3":
                    System.out.println("Please, enter the id");
                    String employeeId = scanner.nextLine();
                    Employee foundEmployee = storage.searchById(employeeId);
                    foundEmployee(foundEmployee);
                    break;
                case "4":
                    System.out.println("Please, enter the company name");
                    String companyName = scanner.nextLine();
                    Employee matchEmployee = storage.searchByCompanyName(companyName);
                    foundEmployee(matchEmployee);
                    break;
                default:
                    System.out.println(" Enter only 0 , 1, 2, 3 or 4");
            }

        }
    }
}

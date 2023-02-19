package homework.homework8;


import homework.homework8.model.Employee;
import homework.homework8.storage.EmployeeStorage;
import homework.homework8.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class EmployeeDemo implements Commands {

    private static final EmployeeStorage EMPLOYEE_STORAGE = new EmployeeStorage();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String input = SCANNER.nextLine();
            switch (input) {
                case EXIT -> isRun = false;
                case ADD_EMPLOYEE -> createEmployee();
                case PRINT_ALL_EMPLOYEES -> printAllEmployees();
                case SEARCH_EMPLOYEE_BY_ID -> searchEmployeeById();
                case SEARCH_EMPLOYEE_BY_COMPANY_NAME -> searchEmployeeByCompanyName();
                case SEARCH_EMPLOYEE_BY_SALARY_RANGE -> searchEmployeeBySalaryRange();
                case CHANGE_EMPLOYEE_POSITION -> updateEmployeePosition();
                case PRINT_ONLY_ACTIVE_EMPLOYEES -> printActiveEmployees();
                case INACTIVATE_EMPLOYEE_BY_ID -> inactivateEmployee();
                case ACTIVATE_EMPLOYEE_BY_ID -> activateEmployee();
                default -> System.out.println("Enter only 0 , 1, 2, 3, 4, 5, 6, 7, 8 or 9");
            }

        }
    }


    private static void createEmployee() throws ParseException {
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
        System.out.println("Please enter birthday in dd/MM/yyyy format");
        String birthday = SCANNER.nextLine();
        Employee employee = new Employee(name, surname, id, Double.parseDouble(salary), company, position,
                new Date(), DateUtil.StringToDate(birthday));
        if (EMPLOYEE_STORAGE.existsById(id)) {
            System.err.println("Employee with such id already exists. ");
        } else {
            EMPLOYEE_STORAGE.addEmployee(employee);
        }
    }


    private static void searchEmployeeById() {
        System.out.println("Please, enter the id");
        String employeeId = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.searchById(employeeId);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("No such employee exists.");
        }
    }

    private static void searchEmployeeByCompanyName() {
        System.out.println("Please, enter the company name");
        String companyName = SCANNER.nextLine();
        Employee[] employees = EMPLOYEE_STORAGE.searchByCompanyName(companyName);
        if (employees == null) {
            System.out.println("No such employee exists.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }


    private static void printAllEmployees() {

        EMPLOYEE_STORAGE.printAllEmployees();
    }

    private static void printActiveEmployees() {
        EMPLOYEE_STORAGE.printActiveEmployees();
    }

    private static void inactivateEmployee() {
        System.out.println("Please, enter employee's id for inactivating.");
        String id = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.searchById(id);
        if (employee == null) {
            System.out.println("Employee with such an id does not exist!");
        } else if (employee.isActive()) {
            employee.setActive(false);
            System.out.println("Successfully inactivated");
            System.out.println(employee);
        }
    }

    private static void activateEmployee() {
        System.out.println("Please, enter employee's id for activating.");
        String id = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.searchById(id);
        if (employee == null) {
            System.out.println("Employee with such an id does not exist!");
        } else if (!employee.isActive()) {
            employee.setActive(true);
            employee.setRegisterDate(new Date());
            System.out.println("Successfully activated");
            System.out.println(employee);
        }

    }

    private static void searchEmployeeBySalaryRange() {
        System.out.println("PLease, enter the minimum salary");
        String minSalary = SCANNER.nextLine();
        System.out.println("PLease, enter the maximum salary");
        String maxSalary = SCANNER.nextLine();
        Employee[] employees = EMPLOYEE_STORAGE.searchBySalaryRange(Double.parseDouble(minSalary), Double.parseDouble(maxSalary));
        if (employees == null) {
            System.out.println("Employees with such salary range don't exist");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void updateEmployeePosition() {
        System.out.println("Please, enter employee's id for changing position");
        String id = SCANNER.nextLine();
        System.out.println("Please, enter employee's new position");
        String newPosition = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.searchById(id);
        if (employee == null) {
            System.out.println("Employee with such an id does not exist!");
        } else {
            employee.setPosition(newPosition);
            System.out.println("Successfully updated");
            System.out.println(employee);
        }
    }


}

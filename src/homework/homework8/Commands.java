package homework.homework8;

public interface Commands {
    String EXIT = "0";
    String ADD_EMPLOYEE = "1";
    String PRINT_ALL_EMPLOYEES = "2";
    String SEARCH_EMPLOYEE_BY_ID = "3";
    String SEARCH_EMPLOYEE_BY_COMPANY_NAME = "4";
    String SEARCH_EMPLOYEE_BY_SALARY_RANGE = "5";
    String CHANGE_EMPLOYEE_POSITION = "6";
    String PRINT_ONLY_ACTIVE_EMPLOYEES = "7";
    String INACTIVATE_EMPLOYEE_BY_ID = "8";
    String ACTIVATE_EMPLOYEE_BY_ID = "9";

    static void printCommands() {
        System.out.println("Please, enter " + EXIT + " For exiting the program.");
        System.out.println("Please, enter " + ADD_EMPLOYEE + " For adding an employee");
        System.out.println("Please, enter " + PRINT_ALL_EMPLOYEES + " For printing all the employees");
        System.out.println("Please, enter " + SEARCH_EMPLOYEE_BY_ID + " For finding the employee by id");
        System.out.println("Please, enter " + SEARCH_EMPLOYEE_BY_COMPANY_NAME + " For finding the employee by company name");
        System.out.println("Please, enter " + SEARCH_EMPLOYEE_BY_SALARY_RANGE + " For searching employees by salary range");
        System.out.println("Please, enter " + CHANGE_EMPLOYEE_POSITION + " For changing employee's position");
        System.out.println("Please, enter " + PRINT_ONLY_ACTIVE_EMPLOYEES + " For printing only active employees");
        System.out.println("Please, enter " + INACTIVATE_EMPLOYEE_BY_ID + " For inactivating an employee");
        System.out.println("Please, enter " + ACTIVATE_EMPLOYEE_BY_ID + " For activating an employee");

    }
}

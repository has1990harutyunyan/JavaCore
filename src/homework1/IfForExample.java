package homework1;

public class IfForExample {


    public static void main(String[] args) {

        // Finding max value between two variables

        int a = 15;
        int b = 45;

        if (a < b) {
            System.out.println("The variable \'a' is smaller than \'b'. " + "The value of \'b' is " + b + " .");
        }
        if (a > b) {
            System.out.println("The variable \'a' is greater than \'b'. " + "The value of \'a' is " + a + " .");
        }

        // Printing values between two given variables

        for (int i = a; i <= b; i++) {
            if (i < b) {
                System.out.print(i + ",");
            } else {
                System.out.print(i);
            }
        }
        System.out.println();

        // Casting int variables into char type and printing their values

        char aCast = (char) a;
        System.out.println("Tha value of aCast is " + aCast);
        char bCast = (char) b;
        System.out.println("Tha value of bCast is " + bCast);

        // Checking equality between two variables

        if (a == b) {
            System.out.println("a is equal to b");
        } else {
            System.out.println("a is not equal to b");
        }

    }


}

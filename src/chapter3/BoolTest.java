package chapter3;

public class BoolTest {
    public static void main(String[] args) {
        boolean b;
        b = false;
        System.out.println("b is " + b);
        b = true;
        System.out.println(" b is " + b);

        if (b) {
            System.out.println(" This will be executed");
        }
        b = false;
        if (b) {

            System.out.println("This is not executed");
        }
        System.out.println(" 10 > 9 is always " + (10 > 9));


    }
}

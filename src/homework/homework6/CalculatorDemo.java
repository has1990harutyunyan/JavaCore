package homework.homework6;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double a = 25;
        double b = 0;

        System.out.println("The quotient is " + calculator.divide(a, b));
        System.out.println("The difference is " + calculator.minus(a, b));
        System.out.println("The product is " + calculator.multiply(a, b));
        System.out.println("The sum is " + calculator.plus(a, b));
    }
}

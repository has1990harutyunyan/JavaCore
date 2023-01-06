package chapter5;

public class StringSwitch {
    public static void main(String[] args) {
        String str = "two";
        switch (str) {
            case "two":
                System.out.println("two");
                break;
            case "Two":
                System.out.println("Two");
                break;
            case "TWO":
                System.out.println("TWO");
                break;
        }
    }
}

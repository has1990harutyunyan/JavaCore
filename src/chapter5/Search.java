package chapter5;

public class Search {
    public static void main(String[] args) {
        int array[] = {8, 9, 6, 7, 5, 3, 4, 7};
        int value = 5;
        boolean found = false;
        for (int i : array) {
            if (i == value) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Value found");
        }
    }
}

package homework.homework4;

public class ArraySort {
    public static void main(String[] args) {
        int[] numbers = {55, 43, -4, 6, 0, 96, 99, 1};
        //ascending order
        boolean toTerminate = false;
        while (!toTerminate) {
            toTerminate = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int value = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = value;
                    toTerminate = false;
                }
            }
        }
        for (int value : numbers) {
            System.out.print(value + " ");
        }
    }
}

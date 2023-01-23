package homework.additional;

public class ArrayUtil {

    void printRepeatedItems(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int value : array) {
                if (array[i] == value) {
                    count++;

                }
            }
            System.out.println(array[i] + " " + count);
        }
    }
}

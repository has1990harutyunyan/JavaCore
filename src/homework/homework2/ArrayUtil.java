package homework.homework2;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {45, 5, 15, 5522, 85, 999, 101, -5, 26, 100};


        // printing all values
        for (int i = 0; i < array.length; i++) {

            System.out.println("Array" + "[" + i + "] " + "= " + array[i]);

        }
        //   printing max value
        int maxValue = array[0];
        for (int value : array) {
            if (maxValue < value) {
                maxValue = value;

            }

        }

        System.out.println("The max value is this array is " + maxValue);

        //printing min value
        int minValue = array[0];

        for (int i = 0; i < array.length; i++) {

            if (minValue > array[i]) {
                minValue = array[i];

            }
        }

        System.out.println("The min value in this array is " + minValue);


    }


}

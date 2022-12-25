package homework.homework2;

import org.w3c.dom.ls.LSOutput;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {45, 0, -1, 5522, 85, 999, 1001, 5, 26, 100};


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

        // printing all even values
        System.out.println("The even elements in the above array are as follows: " + " ");
        int evenNum = 0;
        for (int value : array) {
            int remainder = value % 2;
            if (remainder == 0) {
                evenNum++;
                System.out.print(value + " ");
            }
        }
        System.out.println("\nThe number of even elements in the above array is " + evenNum);

        // printing all odd values
        System.out.println("\nThe odd elements in the above array are as follows: " + " ");
        int oddNum = 0;
        for (int value : array) {
            int remainder = value % 2;
            if (remainder == 1 || remainder == -1) {
                oddNum++;
                System.out.print(value + " ");
            }
        }
        System.out.println("\nThe number of odd elements in the above array is " + oddNum);

        // printing the sum of all values
        int sum = 0;
        for (int value : array) {
            sum = sum + value;
        }
        System.out.println("\nThe sum of values in the above array is " + sum);

        // Printing the average value of the above array
        System.out.println("\nThe average value of the above array is " + sum / array.length);

        // Printing the first element of the array
        System.out.println("\nThe first element of the array is " + array[0]);

        // Printing the last element of the array
        System.out.println("\nThe last element of the array is " + array[array.length - 1]);

        // Printing the middle element for even array
        int midElement1;
        if (array.length % 2 == 0) {
            midElement1 = array.length / 2;
            System.out.println("\nThe middle elements in this array are " + array[midElement1 - 1] + " and " + array[midElement1]);

        }
        // Printing the middle element for odd array
        double midElement2;
        if (array.length % 2 == 1) {
            midElement2 = (array.length / 2);
            double midIndex = midElement2 + 0.5;
            System.out.println("The middle element in this array is " + array[(int) midIndex] + " under index " + midElement2);

        }

        // Same method as the previous one with different logic
        int midElement3;
        if (array.length > 0 && array.length % 2 == 1) {
            midElement3 = (array.length - 1) / 2;
            System.out.println("The middle element in this array is " + array[midElement3] + " under index " + midElement3);


        }

    }


}

package homework.homework4;

public class ArraySort {
    public static void main(String[] args) {
        int[] numbers = {55, 43, -4, 6, 0, 78, 65, 3, 7, 85};
        int initialValue = 0;
        //ascending order
        boolean sortedArrayByAscendingOrder = false;
        int i = initialValue;
        int count1 = initialValue;
        while (i < numbers.length - 1) {
            if (numbers[i] > numbers[i + 1]) {
                int value = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = value;
                count1++;
            }
            i++;
            if (i == numbers.length - 1 && count1 > 0) {
                i = initialValue;
                count1 = initialValue;
            } else if (i == numbers.length - 1 && count1 == 0) {
                sortedArrayByAscendingOrder = true;
            }
            if (sortedArrayByAscendingOrder) {
                break;
            }
        }

        System.out.print("Array sorted by ascending order: ");
        for (int value : numbers) {
            System.out.print(value + " ");
        }
        System.out.println();

        //descending order

        int j = initialValue;
        int count2 = initialValue;
        boolean sortedArrayByDescendingOrder = false;
        while (j < numbers.length - 1) {
            if (numbers[j] < numbers[j + 1]) {
                int value = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = value;
                count2++;
            }
            j++;
            if (j == numbers.length - 1 && count2 > 0) {
                j = initialValue;
                count2 = initialValue;
            } else if (j == numbers.length - 1 && count2 == 0) {
                sortedArrayByDescendingOrder = true;
            }
            if (sortedArrayByDescendingOrder) {
                break;
            }
        }
        System.out.print("Array sorted by descending order: ");
        for (int value : numbers) {
            System.out.print(value + " ");
        }
    }
}




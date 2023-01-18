package homework;

import java.net.Socket;

public class DynamicArray {

    private int[] array = new int[10];
    private int size = 0;

    public void extend() {
        int[] extendedArray = new int[array.length * 2];
        int index = 0;
        for (int i : array) {
            extendedArray[index] = i;
            index++;
        }
        this.array = extendedArray;
    }

    public void add(int value) {
        if (size == array.length) {
            extend();
        } else {
            array[size] = value;
            size++;
        }
    }

    public void print() {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public int getByIndex(int index) {
        if (index >= 0 && index <= array.length - 1) {
            for (int i = 0; i < array.length; i++) {
                return array[index];
            }
        }
        return -1;
    }

}

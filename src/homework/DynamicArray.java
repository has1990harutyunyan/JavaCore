package homework;


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
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public int getByIndex(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        return array[index];
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("Index is out of bounds.");
            return;
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        print();

    }

}



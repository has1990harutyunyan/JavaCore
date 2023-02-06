package homework.homework6;


public class DynamicArray {

    private int[] array = new int[10];
    private int size = 0;

    private void extend() {
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
        if (index < 0 || index > size - 1) {
            return -1;
        }
        return array[index];
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("Index is out of bounds.");
            return;
        }
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        print();

    }

    public void set(int index, int value) {
        if (index < 0 || index > size - 1) {
            System.out.println("No such index exists.");
            return;
        }
        array[index] = value;

    }

    public void add(int index, int value) {
        if (index < 0 || index > size - 1) {
            System.out.println("No such index exists. ");
            return;
        }
        if (size == array.length) {
            extend();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    public boolean exists(int value) {
        boolean b = false;
        for (int i : array) {
            if (i == value) {
                b = true;
                break;
            }
        }
        return b;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }


}





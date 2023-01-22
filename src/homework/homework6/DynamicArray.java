package homework.homework6;


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

    public void set(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("No such index exists.");
            return;
        }
        array[index] = value;
        print();
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("No such index exists. ");
            return;
        }
        size++;

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        print();
    }

    public boolean exists(int value) {
        for (int i : array) {
            if (i == value)
                return true;
        }
        return false;
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





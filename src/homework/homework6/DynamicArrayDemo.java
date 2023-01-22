package homework.homework6;

import homework.homework6.DynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 5; i++) {
            dynamicArray.add(10 - i);
        }
        // dynamicArray.print();
        System.out.println();
        //   System.out.println(dynamicArray.getByIndex(36));
        //   dynamicArray.deleteByIndex(20);
        //  dynamicArray.print();
        dynamicArray.set(0, 4);
        System.out.println();
        dynamicArray.add(0, 9);
        System.out.println();
        System.out.println(dynamicArray.exists(11));
        System.out.println(dynamicArray.getIndexByValue(9));

    }
}

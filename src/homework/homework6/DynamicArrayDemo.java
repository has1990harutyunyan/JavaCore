package homework.homework6;

import homework.homework6.DynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 11; i++) {
            dynamicArray.add(10 - i);
        }
        // dynamicArray.print();
        System.out.println();
        //   System.out.println(dynamicArray.getByIndex(36));
        //   dynamicArray.deleteByIndex(20);
        //  dynamicArray.print();
//        dynamicArray.set(0, 4);
//        System.out.println();
//        dynamicArray.add(0, 9);
//        System.out.println();
//        System.out.println(dynamicArray.exists(911));
//        System.out.println(dynamicArray.getIndexByValue(9));
        //  dynamicArray.print();

//dynamicArray.deleteByIndex(9);
//dynamicArray.deleteByIndex(9);
        dynamicArray.print();
        System.out.println(dynamicArray.getByIndex(10));
    }
}

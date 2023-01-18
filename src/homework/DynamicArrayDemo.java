package homework;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 99; i++) {
            dynamicArray.add(20 + i);
        }
        dynamicArray.print();
        System.out.println();
        System.out.println(dynamicArray.getByIndex(100));

    }
}

package homework;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 5; i++) {
            dynamicArray.add(10-i);
        }
       // dynamicArray.print();
        System.out.println();
     //   System.out.println(dynamicArray.getByIndex(36));
      dynamicArray.deleteByIndex(20);
      //  dynamicArray.print();


    }
}

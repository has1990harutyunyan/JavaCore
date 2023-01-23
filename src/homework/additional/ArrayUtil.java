package homework.additional;

import java.util.HashMap;
import java.util.Map;

public class ArrayUtil {

    void printRepeatedItems(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int value : array) {
                if (array[i] == value) {
                    count++;
                    hashMap.put(array[i], count);
                }
            }

        }
        for (Map.Entry<Integer, Integer> set : hashMap.entrySet()) {
            System.out.println(set.getKey() + " " + set.getValue());

        }

    }
}

package chapter7;

import java.util.Map;

public class Factorial {
    int fact(int n) {
        int result;
        if (n == 1) {
            return 1;
        }
        result = fact(n - 1) * n;
        System.out.println(result);
        return result;

    }


}

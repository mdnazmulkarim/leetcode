import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Revisiting fibonacci");
        int n = 7;
        System.out.println("Fibonacci :" + n + " is:" + new Fibonacci().fib(n));
        // 1  1  2  3
    }

    private int fibonacci(int n) {

        Map<Integer, Integer> map = new HashMap<>();

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = 1;
        if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = fibonacci(n - 1) + fibonacci(n - 2);
        }
        System.out.println("fib of " + n + "is:" + result);
        map.put(n, result);
        return result;
    }

    private int fib(int n) {

        int r , r1=1 , r2 = 1;

        if (n == 1 || n == 2) {
            r2 = 1;
        } else {
            for(int i = 3; i<=n; i++) {
                r = r1+r2;
                r1 = r2;
                r2 = r;
            }
        }
        return r2;
    }
}

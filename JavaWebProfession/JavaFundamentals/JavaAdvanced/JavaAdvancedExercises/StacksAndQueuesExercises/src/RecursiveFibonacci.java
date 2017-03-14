import java.util.HashMap;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = console.nextInt();

        HashMap<Integer, Long> nValue = new HashMap<>();

        System.out.println(getFibonacci(n, nValue));
    }

    public static long getFibonacci(int n, HashMap<Integer, Long> nValue) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            if (!nValue.containsKey(n)) {
                nValue.put(n, getFibonacci(n - 1, nValue) + getFibonacci(n - 2, nValue));
            }

            return nValue.get(n);
        }
    }
}
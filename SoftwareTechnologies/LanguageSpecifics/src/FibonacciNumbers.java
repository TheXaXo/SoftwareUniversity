import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        System.out.println(Fibonacci(n));
    }
    public static long Fibonacci(int n){
        long first = 0;
        long second = 1;
        long oldSecond = 0;

        for (int i = 1; i <= n; i++){
            oldSecond = second;
            second = first + second;
            first = oldSecond;
        }

        return second;
    }
}
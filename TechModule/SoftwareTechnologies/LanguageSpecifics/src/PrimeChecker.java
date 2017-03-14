import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        long number = Long.parseLong(console.nextLine());

        boolean isPrime = isPrime(number);
        if (isPrime){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
    public static boolean isPrime(long number){
        if (number < 2){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
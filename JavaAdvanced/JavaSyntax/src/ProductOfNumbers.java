import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int firstNumber = console.nextInt();
        int secondNumber = console.nextInt();

        BigInteger result = new BigInteger("1");

        for (int i = firstNumber; i <= secondNumber; i++) {
            BigInteger number = new BigInteger(Integer.toString(i));

            result = result.multiply(number);
        }

        System.out.printf("product[%d..%d] = %s", firstNumber, secondNumber, result);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class MultiplyBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number1 = new BigInteger(reader.readLine());
        BigInteger number2 = new BigInteger(reader.readLine());

        System.out.println(number1.multiply(number2));
    }
}
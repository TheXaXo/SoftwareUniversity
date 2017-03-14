import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertFromBase10ToBaseN {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        BigInteger base = new BigInteger(input[0]);
        BigInteger numberToBeConverted = new BigInteger(input[1]);

        StringBuilder number = new StringBuilder();

        while (!numberToBeConverted.toString().equals("0")) {
            BigInteger[] elements = numberToBeConverted.divideAndRemainder(base);

            numberToBeConverted = elements[0];
            number.append(elements[1]);
        }

        System.out.println(number.reverse().toString());
    }
}
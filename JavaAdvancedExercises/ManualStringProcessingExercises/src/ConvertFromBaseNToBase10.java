import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertFromBaseNToBase10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int base = Integer.parseInt(input[0]);
        StringBuilder numberStr = new StringBuilder(input[1]).reverse();

        int n = 0;
        BigInteger result = new BigInteger("0");

        for (char digit : numberStr.toString().toCharArray()) {
            BigInteger digitBigInt = new BigInteger(Character.toString(digit));
            BigInteger multiplier = new BigInteger(Integer.toString(base));
            multiplier = multiplier.pow(n);

            digitBigInt = digitBigInt.multiply(multiplier);

            result = result.add(digitBigInt);

            n++;
        }

        System.out.println(result);
    }
}
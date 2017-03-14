import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        String aHexadecimal = Integer.toHexString(a).toUpperCase();
        String aBinary = Integer.toBinaryString(a);

        while (aBinary.length() < 10) {
            aBinary = "0" + aBinary;
        }

        if (aBinary.length() > 10) {
            aBinary = aBinary.substring(0, 10);
        }

        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", aHexadecimal, aBinary, b, c);
    }
}
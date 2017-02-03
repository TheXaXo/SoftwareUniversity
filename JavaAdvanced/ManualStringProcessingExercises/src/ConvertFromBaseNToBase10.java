import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertFromBaseNToBase10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int base = Integer.parseInt(input[0]);
        StringBuilder numberStr = new StringBuilder(input[1]).reverse();

        int n = 0;
        int result = 0;

        for (char digit : numberStr.toString().toCharArray()) {
            result += Integer.parseInt(Character.toString(digit)) * Math.pow(base, n);

            n++;
        }

        System.out.println(result);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder sb = new StringBuilder(input);

        while (sb.length() < 20) {
            sb.append("*");
        }

        if (sb.length() > 20) {
            sb = sb.delete(20, sb.length());
        }

        System.out.println(sb.toString());
    }
}
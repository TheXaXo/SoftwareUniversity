import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern p = Pattern.compile("^[\\w-]{3,16}$");

        while (!input.equals("END")) {
            Matcher m = p.matcher(input);

            if (m.find()) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

            input = reader.readLine();
        }
    }
}
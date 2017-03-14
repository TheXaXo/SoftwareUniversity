import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern p = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2}) (AM|PM)$");

        while (!input.equals("END")) {
            Matcher m = p.matcher(input);

            if (m.find()) {
                int hour = Integer.parseInt(m.group(1));
                int minute = Integer.parseInt(m.group(2));
                int second = Integer.parseInt(m.group(3));

                if (hour >= 1 && hour <= 12 && minute <= 59 && second <= 59) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            } else {
                System.out.println("invalid");
            }

            input = reader.readLine();
        }
    }
}
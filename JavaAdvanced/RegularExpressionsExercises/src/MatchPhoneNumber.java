import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Pattern p = Pattern.compile("\\+359([- ])2\\1\\d{3}\\1\\d{4}");

        while (!line.equals("end")) {
            Matcher m = p.matcher(line);

            if (m.matches()) {
                System.out.println(m.group());
            }

            line = reader.readLine();
        }
    }
}
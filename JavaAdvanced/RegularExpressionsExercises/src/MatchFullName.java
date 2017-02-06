import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Pattern p = Pattern.compile("[A-Z][a-z]+\\s[A-Z][a-z]+");

        while (!line.equals("end")) {
            Matcher m = p.matcher(line);

            if (m.matches()) {
                System.out.println(m.group());
            }

            line = reader.readLine();
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Pattern p = Pattern.compile("<.+?>");

        while (!line.equals("END")) {

            Matcher m = p.matcher(line);

            while (m.find()) {
                System.out.println(m.group());
            }

            line = reader.readLine();
        }
    }
}
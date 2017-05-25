import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        StringBuilder wholeInput = new StringBuilder();
        while (!line.equals("END")) {
            wholeInput.append(line).append("\r\n");

            line = reader.readLine();
        }

        Pattern p = Pattern.compile("<a(\\s+href=[^>]*)>([^<]+)<\\/a>");
        Matcher m = p.matcher(wholeInput);

        while (m.find()) {
            int matchStart = m.start();
            int matchEnd = m.end();

            String stringToReplace = "[URL" + m.group(1) + "]" + m.group(2) + "[/URL]";

            wholeInput.replace(matchStart, matchEnd, stringToReplace);

            m = p.matcher(wholeInput);
        }

        System.out.println(wholeInput);
    }
}
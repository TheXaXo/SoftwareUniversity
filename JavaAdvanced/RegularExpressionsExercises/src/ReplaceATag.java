import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder wholeInput = new StringBuilder();

        while (!input.equals("END")) {
            wholeInput.append(input).append("\r\n");

            input = reader.readLine();
        }

        Pattern p = Pattern.compile("<a (href=[^>]+)>([^<]+)<\\/a>");
        Matcher m = p.matcher(wholeInput);

        while (m.find()) {
            System.out.println(m.replaceAll("[URL " + m.group(1) + "]" + m.group(2) + "[/URL]"));
        }
    }
}
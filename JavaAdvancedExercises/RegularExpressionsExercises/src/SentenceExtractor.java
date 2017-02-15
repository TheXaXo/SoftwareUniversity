import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyword = reader.readLine();
        String input = reader.readLine();

        Pattern p = Pattern.compile("[A-Z][^!?.]+\\b" + keyword + "\\b[^!?.]*[!?.]");
        Matcher m = p.matcher(input);

        while (m.find()) {
            System.out.println(m.group().trim());
        }
    }
}
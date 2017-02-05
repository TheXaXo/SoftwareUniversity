import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();
        String input = reader.readLine();

        Pattern p = Pattern.compile(word);
        Matcher m = p.matcher(input);

        int count = 0;

        while (m.find()) {
            count++;
        }

        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractIntegerNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
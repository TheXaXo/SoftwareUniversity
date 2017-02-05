import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();

        Pattern p = Pattern.compile("[aeiouy]");
        Matcher m = p.matcher(input);

        int count = 0;

        while (m.find()) {
            count++;
        }

        System.out.printf("Vowels: %d", count);
    }
}
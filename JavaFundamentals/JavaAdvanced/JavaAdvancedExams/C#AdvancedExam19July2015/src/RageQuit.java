import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Pattern p = Pattern.compile("([^0-9]+)([0-9]+)");
        Matcher m = p.matcher(line);

        StringBuilder sb = new StringBuilder();

        HashSet<Character> uniqueChars = new HashSet<>();

        while (m.find()) {
            String string = m.group(1).toUpperCase();
            int count = Integer.parseInt(m.group(2));

            if (count == 0) {
                continue;
            }

            for (int i = 0; i < count; i++) {
                sb.append(string);
            }

            for (char c : string.toCharArray()) {
                uniqueChars.add(c);
            }
        }

        System.out.printf("Unique symbols used: %d%n", uniqueChars.size());
        System.out.println(sb);
    }
}
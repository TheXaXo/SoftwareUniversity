import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(reader.readLine());

        Pattern p = Pattern.compile("\\|([^\\|]*)\\|");
        Matcher m = p.matcher(sb);

        while (m.find()) {
            String match = m.group();
            String insideMatch = m.group(1);

            int sum = 0;

            for (char c : insideMatch.toCharArray()) {
                sum += c;
            }

            int countToRemove = sum % 10;

            int startIndex = sb.indexOf(match) - countToRemove;
            int endIndex = sb.indexOf(match) + match.length() + countToRemove - 1;

            if (startIndex < 0) {
                startIndex = 0;
            }

            if (endIndex >= sb.length()) {
                endIndex = sb.length() - 1;
            }

            StringBuilder dots = new StringBuilder();

            for (int i = startIndex; i <= endIndex; i++) {
                dots.append(".");
            }

            sb.replace(startIndex, endIndex + 1, dots.toString());

            m = p.matcher(sb);
        }

        System.out.println(sb);
    }
}
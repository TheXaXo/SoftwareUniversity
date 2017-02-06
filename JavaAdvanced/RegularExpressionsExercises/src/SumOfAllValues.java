import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keysString = reader.readLine();
        String input = reader.readLine();

        Pattern startKey = Pattern.compile("^([A-Za-z_]+)\\d+");
        Pattern endKey = Pattern.compile("\\d+([A-Za-z_]+)$");

        Matcher startMatcher = startKey.matcher(keysString);
        Matcher endMatcher = endKey.matcher(keysString);

        if (!startMatcher.find() || !endMatcher.find()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        Pattern numbersPattern = Pattern.compile(startMatcher.group(1) + "(\\d+(?:\\.\\d+)*)" + endMatcher.group(1));
        Matcher allNumbers = numbersPattern.matcher(input);

        double sum = 0;

        while (allNumbers.find()) {
            sum += Double.parseDouble(allNumbers.group(1));
        }

        if (sum == 0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        }
    }
}
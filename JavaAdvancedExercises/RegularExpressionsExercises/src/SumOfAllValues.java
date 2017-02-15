import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keysString = reader.readLine();
        String input = reader.readLine();

        Pattern p = Pattern.compile("^([A-Za-z_]+)\\d.*?\\d([A-Za-z_]+)$");
        Matcher m = p.matcher(keysString);

        if (!m.find()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String startKey = m.group(1);
        String endKey = m.group(2);

        Pattern numberPattern = Pattern.compile(startKey + "(.*?)" + endKey);
        Matcher numberMatcher = numberPattern.matcher(input);

        double sum = 0;

        while (numberMatcher.find()) {
            try {
                sum += Double.parseDouble(numberMatcher.group(1));
            } catch (Exception ex) {

            }
        }

        if (sum == 0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            System.out.println(String.format("<p>The total value is: <em>%s</em></p>", new DecimalFormat("#.##").format(sum)));
        }
    }
}
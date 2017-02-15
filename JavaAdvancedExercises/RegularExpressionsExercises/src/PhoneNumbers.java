import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        StringBuilder sb = new StringBuilder();

        while (!line.equals("END")) {
            sb.append(line);

            line = reader.readLine();
        }

        Pattern p = Pattern.compile("([A-Z][A-Za-z]*)[^A-Za-z0-9\\+]*(\\+)*(\\d[\\d()\\/.,\\-\\s]*\\d)");
        Matcher m = p.matcher(sb);

        StringBuilder output = new StringBuilder();
        output.append("<ol>");

        int matches = 0;

        while (m.find()) {
            String name = m.group(1);
            String symbol = m.group(2);
            String phoneNumber = m.group(3);

            StringBuilder fixedNumber = new StringBuilder();

            if (symbol != null) {
                fixedNumber.append(symbol);
            }

            int digitsCount = 0;

            for (char c : phoneNumber.toCharArray()) {
                if (c >= 48 && c <= 57) {
                    fixedNumber.append(c);
                }

                digitsCount++;
            }

            if (digitsCount < 2) {
                continue;
            }

            output.append("<li><b>").append(name).append(":</b> ").append(fixedNumber).append("</li>");
            matches++;
        }

        if (matches == 0) {
            System.out.println("<p>No matches!</p>");
            return;
        }

        output.append("</ol>");

        System.out.println(output);
    }
}
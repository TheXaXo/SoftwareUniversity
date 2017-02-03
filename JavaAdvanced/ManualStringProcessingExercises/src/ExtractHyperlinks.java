import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String row = reader.readLine();

        StringBuilder wholeHtml = new StringBuilder();

        while (!row.equals("END")) {
            wholeHtml.append(row);

            row = reader.readLine();
        }

        Pattern p = Pattern.compile("<a.*?href.?=\\s*(.+?)[\\s>]");
        Matcher m = p.matcher(wholeHtml);

        while (m.find()) {
            StringBuilder match = new StringBuilder(m.group(1));

            if (match.charAt(0) == '\"' || match.charAt(0) == '\'') {
                match.deleteCharAt(0);
                match.deleteCharAt(match.length() - 1);
            }

            System.out.println(match);
        }
    }
}
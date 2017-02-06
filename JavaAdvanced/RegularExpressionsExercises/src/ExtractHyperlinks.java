import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        StringBuilder sb = new StringBuilder();

        while (!line.equals("END")) {
            sb.append(line);

            line = reader.readLine();
        }

        Pattern p = Pattern.compile("<a[^>]+href\\s*=\\s*([\"'])*(.+?)\\1*[<>\\s]");
        Matcher m = p.matcher(sb);

        while (m.find()) {
            System.out.println(m.group(2));
        }
    }
}
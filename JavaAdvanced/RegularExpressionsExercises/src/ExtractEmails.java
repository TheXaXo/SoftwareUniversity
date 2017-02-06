import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        StringBuilder sb = new StringBuilder();

        while (!line.equals("end")) {
            sb.append(line).append("\n");

            line = reader.readLine();
        }

        Pattern p = Pattern.compile("(^|\\s)([A-Za-z]+([\\._-]+[A-Za-z]+)*@[A-Za-z]+([-][A-Za-z]+)*(\\.[A-Za-z]+([-][A-Za-z]+)*){1,})($|[\\.,\\s])", Pattern.DOTALL);
        Matcher m = p.matcher(sb);

        while (m.find()) {
            System.out.println(m.group(2));
        }
    }
}
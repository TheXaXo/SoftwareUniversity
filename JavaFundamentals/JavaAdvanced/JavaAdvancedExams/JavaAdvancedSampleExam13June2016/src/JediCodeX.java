import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediCodeX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] lines = new String[n];

        for (int i = 0; i < n; i++) {
            lines[i] = reader.readLine();
        }

        String jediKeyword = reader.readLine();
        String messageKeyword = reader.readLine();

        Pattern jediP = Pattern.compile(jediKeyword + "([A-Za-z]+)");
        Pattern messageP = Pattern.compile(messageKeyword + "([A-Za-z0-9]+)");

        ArrayList<String> jedis = new ArrayList<>();
        ArrayList<String> messages = new ArrayList<>();

        for (String line : lines) {
            Matcher jediM = jediP.matcher(line);
            Matcher messageM = messageP.matcher(line);

            while (jediM.find()) {
                if (jediM.group(1).length() == jediKeyword.length()) {
                    jedis.add(jediM.group(1));
                }
            }

            while (messageM.find()) {
                if (messageM.group(1).length() == messageKeyword.length()) {
                    messages.add(messageM.group(1));
                }
            }
        }

        int[] indexes = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(a -> a - 1)
                .toArray();

        int jediIndex = 0;
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] < messages.size() && jediIndex < jedis.size()) {
                System.out.printf("%s - %s%n", jedis.get(jediIndex), messages.get(indexes[i]));
                jediIndex++;
            }
        }
    }
}
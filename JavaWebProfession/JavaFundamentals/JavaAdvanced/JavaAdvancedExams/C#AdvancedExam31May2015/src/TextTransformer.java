import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTransformer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        StringBuilder inputSb = new StringBuilder();

        while (!line.equals("burp")) {
            inputSb.append(line);

            line = reader.readLine();
        }

        String input = inputSb.toString().replaceAll("\\s+", "\\s");

        Pattern p = Pattern.compile("([$%&'])([^$%&']+)\\1");
        Matcher m = p.matcher(input);

        ArrayList<String> words = new ArrayList<>();

        while (m.find()) {
            char delimiter = m.group(1).charAt(0);
            String string = m.group(2);

            int power = 0;

            switch (delimiter) {
                case '$':
                    power = 1;
                    break;

                case '%':
                    power = 2;
                    break;

                case '&':
                    power = 3;
                    break;

                case '\'':
                    power = 4;
                    break;
            }

            StringBuilder word = new StringBuilder();

            for (int i = 0; i < string.length(); i++) {
                if (i % 2 == 0) {
                    word.append((char) ((int) string.charAt(i) + power));
                } else {
                    word.append((char) ((int) string.charAt(i) - power));
                }
            }

            words.add(word.toString());
        }

        System.out.println(String.join(" ", words));
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascend {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern p = Pattern.compile("([,_])([A-Za-z]+)([0-9])");

        String command = reader.readLine();

        LinkedHashMap<String, String> memorized = new LinkedHashMap<>();

        while (!command.equals("Ascend")) {
            StringBuilder line = new StringBuilder(command);

            Matcher m = p.matcher(line);

            while (m.find()) {
                char symbol = m.group(1).charAt(0);
                String message = m.group(2);
                int number = Integer.parseInt(m.group(3));

                if (memorized.containsKey(message)) {
                    line = line.replace(line.indexOf(message), line.indexOf(message) + message.length(), memorized.get(message));
                    m = p.matcher(line);
                    continue;
                }

                StringBuilder newMessage = new StringBuilder();

                if (symbol == ',') {
                    for (char c : message.toCharArray()) {
                        newMessage.append((char) (c + number));
                    }
                } else {
                    for (char c : message.toCharArray()) {
                        newMessage.append((char) (c - number));
                    }
                }

                line.replace(line.indexOf(m.group()), line.indexOf(m.group()) + m.group().length(), newMessage.toString());

                m = p.matcher(line);

                memorized.put(message, newMessage.toString());
            }

            System.out.println(line);
            command = reader.readLine();
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        Pattern p = Pattern.compile("(\\d+)([A-Za-z]+)([^A-Za-z]*)");

        while (!command.equals("Over!")) {
            String input = command;
            int desiredLength = Integer.parseInt(reader.readLine());

            Matcher m = p.matcher(input);

            if (!m.matches() || m.group(2).length() != desiredLength) {
                command = reader.readLine();
                continue;
            }

            StringBuilder verificationCode = new StringBuilder();
            String message = m.group(2);


            for (char c : m.group(1).toCharArray()) {
                int index = Integer.parseInt(Character.toString(c));

                if (index >= 0 && index < message.length()) {
                    verificationCode.append(message.charAt(index));
                } else {
                    verificationCode.append(" ");
                }
            }

            if (m.group(3) != null) {
                for (char c : m.group(3).toCharArray()) {
                    if (Character.isDigit(c)) {
                        int index = Integer.parseInt(Character.toString(c));

                        if (index >= 0 && index < message.length()) {
                            verificationCode.append(message.charAt(index));
                        } else {
                            verificationCode.append(" ");
                        }
                    }
                }
            }

            System.out.printf("%s == %s%n", message, verificationCode);
            command = reader.readLine();
        }
    }
}

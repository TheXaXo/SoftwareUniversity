import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseYourChains {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        Pattern p = Pattern.compile("<p>(.+?)<\\/p>");
        Matcher m = p.matcher(input);

        StringBuilder message = new StringBuilder();

        while (m.find()) {
            message.append(m.group(1));
        }

        for (int i = 0; i < message.length(); i++) {
            if (!(message.charAt(i) >= 97 && message.charAt(i) <= 122) &&
                    !(message.charAt(i) >= 48 && message.charAt(i) <= 57)) {
                message.replace(i, i + 1, " ");
            } else {
                if (message.charAt(i) >= 97 && message.charAt(i) <= 109) {
                    message.replace(i, i + 1, Character.toString((char) (message.charAt(i) + 13)));
                } else if (message.charAt(i) >= 110 && message.charAt(i) <= 122) {
                    message.replace(i, i + 1, Character.toString((char) (message.charAt(i) - 13)));
                }
            }
        }

        String[] messageSplit = Arrays.stream(message.toString().split("\\s"))
                .filter(a -> !a.isEmpty())
                .toArray(size -> new String[size]);

        String messageFormatted = String.join(" ", messageSplit);

        System.out.println(messageFormatted);
    }
}
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestProgram8 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        String pattern = "(\\d+)([a-zA-Z]+)([^a-zA-Z]+)*";
        Pattern p = Pattern.compile(pattern);

        while (!input.equals("Over!")) {
            int length = Integer.parseInt(console.nextLine());
            Matcher m = p.matcher(input);

            if (m.matches() && m.group(2).length() == length) {
                String message = m.group(2);

                String verification = "";
                if (m.group(3) == null) {
                    verification = m.group(1);
                } else {
                    verification = m.group(1).concat(m.group(3));
                }

                StringBuilder sb = new StringBuilder();

                for (char c : verification.toCharArray()) {
                    if ((int) c >= 48 && (int) c <= 57) {
                        int charNumeric = Integer.parseInt(Character.toString(c));
                        if (message.length() > charNumeric) {
                            sb.append(message.charAt(charNumeric));
                        } else {
                            sb.append(" ");
                        }
                    }
                }
                System.out.printf("%s == %s%n", message, sb);
            }

            input = console.nextLine();
        }
    }
}
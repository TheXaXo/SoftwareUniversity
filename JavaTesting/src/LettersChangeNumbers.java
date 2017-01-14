import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] inputArgs = console.nextLine().split("\\s");

        Pattern p = Pattern.compile("([A-Za-z])([0-9]+)([A-Za-z])");

        double result = 0;

        for (String input : inputArgs) {
            Matcher m = p.matcher(input);

            if (!m.matches()) {
                continue;
            }

            char firstLetter = m.group(1).charAt(0);
            char lastLetter = m.group(3).charAt(0);
            double number = Integer.parseInt(m.group(2));

            int firstLetterPosition = Character.toLowerCase(firstLetter) - 96;
            int lastLetterPosition = Character.toLowerCase(lastLetter) - 96;

            if (firstLetter >= 97 && firstLetter <= 122) {
                number *= firstLetterPosition;
            } else {
                number /= firstLetterPosition;
            }

            if (lastLetter >= 97 && lastLetter <= 122) {
                number += lastLetterPosition;
            } else {
                number -= lastLetterPosition;
            }

            result += number;
        }

        System.out.printf("%.2f", result);
    }
}
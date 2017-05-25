package letterExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern p = Pattern.compile("\\d+(?:\\.\\d+)*");
        Matcher m = p.matcher(input);

        Deque<Double> numbers = new ArrayDeque<>();
        Deque<String> numberDelimiters = new ArrayDeque<>();

        while (m.find()) {
            numbers.add(Double.parseDouble(m.group()));
        }

        p = Pattern.compile("[^\\d.]+");
        m = p.matcher(input);

        while (m.find()) {
            numberDelimiters.add(m.group());
        }

        Double sum = null;

        while (!numbers.isEmpty()) {
            if (sum == null) {
                sum = numbers.remove();
                continue;
            }

            if (numberDelimiters.remove().length() % 2 == 0) {
                sum += numbers.remove();
            } else {
                sum -= numbers.remove();
            }
        }

        //Removing trailing zeroes
        String numberAsString = String.format("%.7f", sum).replaceAll("0+$", "");

        if (numberAsString.charAt(numberAsString.length() - 1) == '.') {
            numberAsString = numberAsString.substring(0, numberAsString.length() - 1);
        }

        System.out.println(numberAsString);
    }
}
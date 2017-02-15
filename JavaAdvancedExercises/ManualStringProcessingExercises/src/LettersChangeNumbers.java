import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArgs = reader.readLine().split("\\s+");

        double result = 0;

        for (String word : inputArgs) {

            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);

            double number = Double.parseDouble(word.substring(1, word.length() - 1));

            int positionInAlphabet = 0;

            if (firstChar >= 65 && firstChar <= 90) {
                positionInAlphabet = firstChar - 64;

                result += number /= positionInAlphabet;
            } else {
                positionInAlphabet = firstChar - 96;

                result += number *= positionInAlphabet;
            }

            if (lastChar >= 97 && lastChar <= 122) {
                positionInAlphabet = lastChar - 96;

                result += positionInAlphabet;
            } else {
                positionInAlphabet = lastChar - 64;

                result -= positionInAlphabet;
            }
        }

        System.out.printf("%.2f", result);
    }
}
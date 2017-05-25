import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split(" ");

        Predicate<String> isUpperCase = word -> word.charAt(0) == Character.toUpperCase(word.charAt(0));

        int count = 0;

        ArrayList<String> upperCaseWords = new ArrayList<>();

        for (String word : words) {
            if (isUpperCase.test(word)) {
                count++;
                upperCaseWords.add(word);
            }
        }

        System.out.println(count);

        for (String word : upperCaseWords) {
            System.out.println(word);
        }
    }
}
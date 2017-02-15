import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split("[\\s,\\.?!]");

        HashSet<String> palindromes = new HashSet<>();

        for (String word : words) {
            if (word.length() < 1) {
                continue;
            }

            StringBuilder wordReversed = new StringBuilder(word).reverse();

            boolean isPalindrome = true;

            if (!word.equals(wordReversed.toString())) {
                isPalindrome = false;
            }

            if (isPalindrome) {
                palindromes.add(word);
            }
        }

        ArrayList<String> palindromesAsList = new ArrayList<>(palindromes);
        palindromesAsList.sort(String::compareToIgnoreCase);

        System.out.println(palindromesAsList);
    }
}
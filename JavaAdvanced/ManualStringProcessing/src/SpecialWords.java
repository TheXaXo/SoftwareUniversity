import java.util.HashMap;
import java.util.Scanner;

public class SpecialWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] specialWords = console.nextLine().split(" ");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String specialWord : specialWords) {
            wordCount.put(specialWord, 0);
        }

        String[] inputWords = console.nextLine().split(" ");

        for (String word : inputWords) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            }
        }

        for (String specialWord : wordCount.keySet()) {
            System.out.printf("%s - %d%n", specialWord, wordCount.get(specialWord));
        }
    }
}
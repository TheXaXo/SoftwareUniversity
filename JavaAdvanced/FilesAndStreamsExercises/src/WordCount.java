import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String wordsFilePath = "C:\\Users\\TheXaXo\\Desktop\\words.txt";
        String textPath = "C:\\Users\\TheXaXo\\Desktop\\text.txt";
        String outputPath = "C:\\Users\\TheXaXo\\Desktop\\results.txt";

        try (BufferedReader wordsReader = new BufferedReader(new FileReader(wordsFilePath));
             BufferedReader textReader = new BufferedReader(new FileReader(textPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            HashMap<String, Integer> wordCount = new HashMap<>();

            String[] words = wordsReader.readLine().split(" ");

            for (String word : words) {
                if (!wordCount.containsKey(word)) {
                    wordCount.put(word.toLowerCase(), 0);
                }
            }

            String line = textReader.readLine();

            while (line != null) {
                String[] lineWords = line.split(" ");

                for (String word : lineWords) {
                    if (wordCount.containsKey(word.toLowerCase())) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    }
                }

                line = textReader.readLine();
            }

            wordCount.entrySet().stream()
                    .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(a -> a.getValue()).reversed())
                    .forEach(a -> writer.printf("%s - %d%n", a.getKey(), a.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
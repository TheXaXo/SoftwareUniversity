import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split(" ");
        String word1 = words[0];
        String word2 = words[1];

        String longerWord = "";
        String shorterWord = "";

        if (word1.length() > word2.length()) {
            longerWord = word1;
            shorterWord = word2;
        } else {
            longerWord = word2;
            shorterWord = word1;
        }

        int result = 0;

        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                result += word1.charAt(i) * word2.charAt(i);
            }
        } else {
            for (int i = 0; i < shorterWord.length(); i++) {
                result += longerWord.charAt(i) * shorterWord.charAt(i);
            }

            for (int i = shorterWord.length(); i < longerWord.length(); i++) {
                result += longerWord.charAt(i);
            }
        }

        System.out.println(result);
    }
}
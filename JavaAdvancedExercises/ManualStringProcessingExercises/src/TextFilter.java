import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(", ");

        StringBuilder input = new StringBuilder(reader.readLine());

        for (String bannedWord : bannedWords) {
            int lastIndex = 0;
            int index = input.indexOf(bannedWord, lastIndex);

            StringBuilder stars = new StringBuilder();
            for (int i = 0; i < bannedWord.length(); i++) {
                stars.append("*");
            }

            while (index != -1) {
                input.replace(index, index + bannedWord.length(), stars.toString());
                lastIndex = index + 1;
                index = input.indexOf(bannedWord, lastIndex);
            }
        }

        System.out.println(input);
    }
}
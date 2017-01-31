import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\TheXaXo\\Desktop\\input.txt";
        String outputPath = "C:\\Users\\TheXaXo\\Desktop\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {
            String line = reader.readLine();

            int vowelsCount = 0;
            int consonants = 0;
            int punctuation = 0;

            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vowelsCount++;
                    } else if (c == '!' || c == ',' || c == '.' || c == '?') {
                        punctuation++;
                    } else {
                        consonants++;
                    }
                }

                line = reader.readLine();
            }

            writer.printf("Vowels: %d%nConsonants: %d%nPunctuation: %d%n", vowelsCount, consonants, punctuation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split(" ");

        Arrays.stream(words)
                .map(word -> word.toUpperCase())
                .forEach(word -> System.out.print(word + " "));
    }
}
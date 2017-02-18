import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder(reader.readLine());
        StringBuilder pattern = new StringBuilder(reader.readLine());

        while (input.indexOf(pattern.toString()) != -1
                && input.indexOf(pattern.toString()) != input.lastIndexOf(pattern.toString())
                && pattern.length() != 0) {
            int firstIndex = input.indexOf(pattern.toString());
            input.delete(firstIndex, firstIndex + pattern.length());

            int lastIndex = input.lastIndexOf(pattern.toString());
            input.delete(lastIndex, lastIndex + pattern.length());

            pattern.deleteCharAt(pattern.length() / 2);

            System.out.println("Shaked it.");
        }

        System.out.println("No shake.");

        System.out.println(input);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = reader.readLine().toCharArray();

        StringBuilder output = new StringBuilder();

        for (char c : chars) {
            output.append("\\u");

            String hex = Integer.toHexString(c);
            for (int i = 0; i < 4 - hex.length(); i++) {
                output.append("0");
            }

            output.append(hex);
        }

        System.out.println(output);
    }
}
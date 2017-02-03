import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();
        String substringToSearchFor = reader.readLine().toLowerCase();

        int count = 0;
        int lastFoundIndex = 0;

        int indexOfOccurrence = input.indexOf(substringToSearchFor);

        while (indexOfOccurrence != -1) {
            count++;
            lastFoundIndex = indexOfOccurrence;

            indexOfOccurrence = input.indexOf(substringToSearchFor, lastFoundIndex + 1);
        }

        System.out.println(count);
    }
}
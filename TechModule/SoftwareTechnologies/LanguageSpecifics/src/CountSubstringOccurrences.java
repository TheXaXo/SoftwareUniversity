import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine().toLowerCase();
        String patternAsString = console.nextLine().toLowerCase();

        Pattern pattern = Pattern.compile(patternAsString);
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        int start = 0;
        while (matcher.find(start)){
            count++;
            start = matcher.start() + 1;
        }

        System.out.println(count);
    }
}

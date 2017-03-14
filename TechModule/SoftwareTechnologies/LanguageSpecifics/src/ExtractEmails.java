import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        String patternAsString = "\\s[a-z0-9][\\.\\_\\-a-z0-9]*[a-z0-9]@[a-z0-9][\\.\\-a-z0-9]*[a-z0-9]\\.[a-z]{2,}";

        Pattern pattern = Pattern.compile(patternAsString);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
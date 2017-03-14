import java.util.Scanner;
import java.util.regex.Pattern;

public class TextFilter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] bannedWords = console.nextLine().split(", ");
        String input = console.nextLine();

        for (String banWord : bannedWords){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < banWord.length(); i++){
                sb.append("*");
            }
            input = input.replaceAll(banWord, sb.toString());
        }

        System.out.println(input);
    }
}

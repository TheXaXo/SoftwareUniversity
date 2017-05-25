import java.util.Scanner;

public class ParseTags {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        int index = input.indexOf("<upcase>");
        int endIndex = 0;

        while (index != -1) {
            endIndex = input.indexOf("</upcase>", endIndex);

            String word = input.substring(index + 8, endIndex);

            input = input.replace("<upcase>" + word + "</upcase>", word.toUpperCase());

            index = input.indexOf("<upcase>", index);
        }

        System.out.println(input);
    }
}
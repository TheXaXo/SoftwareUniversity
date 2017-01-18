import java.util.ArrayList;
import java.util.Scanner;

public class NMS {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        StringBuilder wordsCombined = new StringBuilder();

        ArrayList<String> words = new ArrayList<>();

        while (!command.equals("---NMS SEND---")) {
            wordsCombined.append(command);

            command = console.nextLine();
        }

        char[] lettersToLowerCase = wordsCombined.toString().toLowerCase().toCharArray();
        char[] letters = wordsCombined.toString().toCharArray();

        StringBuilder word = new StringBuilder();

        for (int i = 0; i < lettersToLowerCase.length; i++) {
            if (i == 0 || lettersToLowerCase[i] >= lettersToLowerCase[i - 1]) {
                word.append(letters[i]);
            } else {
                words.add(word.toString());

                word = new StringBuilder();
                word.append(letters[i]);
            }

            if (i == lettersToLowerCase.length - 1) {
                words.add(word.toString());
            }
        }

        String delimeter = console.nextLine();

        System.out.println(String.join(delimeter, words));
    }
}
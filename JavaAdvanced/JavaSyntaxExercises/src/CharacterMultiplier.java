import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String wordOne = console.next();
        String wordTwo = console.next();

        System.out.println(getSumOfChars(wordOne, wordTwo));
    }

    public static int getSumOfChars(String one, String two) {
        String longerWord = "";
        String shorterWord = "";

        boolean sameLength = false;

        if (one.length() > two.length()) {
            longerWord = one;
            shorterWord = two;
        } else if (one.length() < two.length()) {
            longerWord = two;
            shorterWord = one;
        } else {
            sameLength = true;
        }

        int result = 0;

        if (sameLength) {
            for (int i = 0; i < one.length(); i++) {
                result = result + (one.charAt(i) * two.charAt(i));
            }
        } else {
            for (int i = 0; i < shorterWord.length(); i++) {
                result = result + (shorterWord.charAt(i) * longerWord.charAt(i));
            }

            String leftOver = longerWord.substring(shorterWord.length());
            for (char c : leftOver.toCharArray()) {
                result += c;
            }
        }

        return result;
    }
}
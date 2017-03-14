import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        String wordOne = tokens[0].toLowerCase();
        String wordTwo = tokens[1].toLowerCase();

        HashMap<Character, Character> chars = new HashMap<>();

        for (int i = 0; i < Math.min(wordOne.length(), wordTwo.length()); i++) {
            if (!chars.containsKey(wordOne.charAt(i)) && !chars.containsValue(wordTwo.charAt(i))) {
                chars.put(wordOne.charAt(i), wordTwo.charAt(i));
            } else {
                if (chars.containsKey(wordOne.charAt(i))) {
                    if (chars.get(wordOne.charAt(i)) != wordTwo.charAt(i)) {
                        System.out.println(false);
                        return;
                    }
                } else {
                    System.out.println(false);
                    return;
                }
            }
        }

        if (wordOne.length() != wordTwo.length()) {
            String longerWord = "";
            String shorterWord = "";

            if (wordOne.length() > wordTwo.length()) {
                longerWord = wordOne;
                shorterWord = wordTwo;
            } else {
                longerWord = wordTwo;
                shorterWord = wordOne;
            }

            String charsToCheck = longerWord.substring(shorterWord.length());

            for (char c : charsToCheck.toCharArray()) {
                if (shorterWord.equals(wordOne)) {
                    if (!chars.containsValue(c)) {
                        System.out.println(false);
                        return;
                    }
                } else {
                    if (!chars.containsKey(c)) {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }

        System.out.println(true);
    }
}
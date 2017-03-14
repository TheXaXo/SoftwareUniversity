import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] userNames = reader.readLine().split("[\\s\\/\\\\()]");

        ArrayList<String> validUserNames = new ArrayList<>();

        Pattern p = Pattern.compile("[A-Za-z]\\w{2,24}");

        for (String username : userNames) {
            Matcher m = p.matcher(username);

            if (m.matches()) {
                validUserNames.add(username);
            }
        }

        int maxLength = Integer.MIN_VALUE;
        String nameOne = "";
        String nameTwo = "";

        for (int i = 0; i < validUserNames.size() - 1; i++) {
            String userNameOne = validUserNames.get(i);
            String userNameTwo = validUserNames.get(i + 1);

            if (userNameOne.length() + userNameTwo.length() > maxLength) {
                maxLength = userNameOne.length() + userNameTwo.length();

                nameOne = userNameOne;
                nameTwo = userNameTwo;
            }
        }

        System.out.println(nameOne);
        System.out.println(nameTwo);
    }
}
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append(console.nextLine());

        Pattern p = Pattern.compile("(\\|[^\\|]+?\\|)");
        Matcher m = p.matcher(sb);

        while (m.find()) {
            String bomb = m.group(1);

            int power = 0;

            for (char c : bomb.toCharArray()) {
                if (c != '|') {
                    power += c;
                }
            }

            power = power % 10;

            int leftIndex = sb.indexOf(bomb) - power;
            int rightIndex = leftIndex + power + bomb.length() - 1 + power;

            if (leftIndex < 0) {
                leftIndex = 0;
            }

            if (rightIndex >= sb.length()) {
                rightIndex = sb.length() - 1;
            }

            for (int i = leftIndex; i <= rightIndex; i++) {
                sb.replace(i, i + 1, ".");
            }
        }

        System.out.println(sb.toString());
    }
}
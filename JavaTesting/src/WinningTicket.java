import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] tickets = Arrays.stream(console.nextLine().split(","))
                .map(String::trim)
                .toArray(String[]::new);

        Pattern p = Pattern.compile("((?:[@#$\\^]){6,10})");

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            String leftPart = ticket.substring(0, 10);
            String rightPart = ticket.substring(10);

            Matcher left = p.matcher(leftPart);
            Matcher right = p.matcher(rightPart);

            if (left.find() && right.find()) {
                String leftMatch = left.group(1);
                String rightMatch = right.group(1);

                if (!leftMatch.equals(rightMatch)) {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                    continue;
                }

                if (leftMatch.length() == 10) {
                    System.out.printf("ticket \"%s\" - %d%s Jackpot!%n",
                            ticket, leftMatch.length(), Character.toString(leftMatch.charAt(0)));
                } else {
                    System.out.printf("ticket \"%s\" - %d%s%n",
                            ticket, leftMatch.length(), Character.toString(leftMatch.charAt(0)));
                }
            } else {
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//KEEP IT SIMPLE STUPID
public class RoyalFlush {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder input = new StringBuilder();

        for (int i = 0; i < n; i++) {
            input.append(reader.readLine());
        }

        Pattern p = Pattern.compile("(.+?)([cdhs])");

        ArrayDeque<Integer> clubs = new ArrayDeque<>();
        ArrayDeque<Integer> diamonds = new ArrayDeque<>();
        ArrayDeque<Integer> hearts = new ArrayDeque<>();
        ArrayDeque<Integer> spades = new ArrayDeque<>();

        Matcher m = p.matcher(input);

        int numberOfFlushes = 0;

        while (m.find()) {
            String rank = m.group(1);
            char club = m.group(2).charAt(0);

            int rankAsInt = 0;

            switch (rank) {
                case "10":
                    rankAsInt = 10;
                    break;
                case "J":
                    rankAsInt = 11;
                    break;
                case "Q":
                    rankAsInt = 12;
                    break;
                case "K":
                    rankAsInt = 13;
                    break;
                case "A":
                    rankAsInt = 14;
                    break;
                default:
                    rankAsInt = Integer.parseInt(rank);
                    break;
            }

            switch (club) {
                case 'c':
                    if (clubs.isEmpty() && rankAsInt >= 10) {
                        clubs.push(rankAsInt);
                    } else if (!clubs.isEmpty()) {
                        if (clubs.peek() + 1 == rankAsInt) {
                            clubs.push(rankAsInt);
                        } else {
                            clubs.clear();

                            if (rankAsInt >= 10) {
                                clubs.push(rankAsInt);
                            }
                        }
                    }
                    break;
                case 'd':
                    if (diamonds.isEmpty() && rankAsInt >= 10) {
                        diamonds.push(rankAsInt);
                    } else if (!diamonds.isEmpty()) {
                        if (diamonds.peek() + 1 == rankAsInt) {
                            diamonds.push(rankAsInt);
                        } else {
                            diamonds.clear();

                            if (rankAsInt >= 10) {
                                diamonds.push(rankAsInt);
                            }
                        }
                    }
                    break;
                case 'h':
                    if (hearts.isEmpty() && rankAsInt >= 10) {
                        hearts.push(rankAsInt);
                    } else if (!hearts.isEmpty()) {
                        if (hearts.peek() + 1 == rankAsInt) {
                            hearts.push(rankAsInt);
                        } else {
                            hearts.clear();

                            if (rankAsInt >= 10) {
                                hearts.push(rankAsInt);
                            }
                        }
                    }
                    break;
                case 's':
                    if (spades.isEmpty() && rankAsInt >= 10) {
                        spades.push(rankAsInt);
                    } else if (!spades.isEmpty()) {
                        if (spades.peek() + 1 == rankAsInt) {
                            spades.push(rankAsInt);
                        } else {
                            spades.clear();

                            if (rankAsInt >= 10) {
                                spades.push(rankAsInt);
                            }
                        }
                    }
                    break;
            }

            if (clubs.size() == 5 && clubs.peek() == 14) {
                clubs.clear();
                System.out.println("Royal Flush Found - Clubs");
                numberOfFlushes++;
            }
            if (diamonds.size() == 5 && diamonds.peek() == 14) {
                diamonds.clear();
                System.out.println("Royal Flush Found - Diamonds");
                numberOfFlushes++;
            }
            if (hearts.size() == 5 && hearts.peek() == 14) {
                hearts.clear();
                System.out.println("Royal Flush Found - Hearts");
                numberOfFlushes++;
            }
            if (spades.size() == 5 && spades.peek() == 14) {
                spades.clear();
                System.out.println("Royal Flush Found - Spades");
                numberOfFlushes++;
            }
        }

        System.out.println("Royal's Royal Flushes - " + numberOfFlushes + ".");
    }
}
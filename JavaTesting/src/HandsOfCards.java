import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        LinkedHashMap<String, ArrayList<String>> personCards = new LinkedHashMap<>();

        while (!command.equals("JOKER")) {
            String[] split = command.split(":");

            String person = split[0].trim();
            ArrayList<String> cards = Arrays.stream(split[1].split(","))
                    .map(String::trim)
                    .distinct()
                    .collect(Collectors.toCollection(ArrayList::new));

            if (!personCards.containsKey(person)) {
                personCards.put(person, cards);
            } else {
                ArrayList<String> currentCards = personCards.get(person);
                currentCards.addAll(cards);

                currentCards = currentCards.stream()
                        .distinct()
                        .collect(Collectors.toCollection(ArrayList::new));

                personCards.put(person, currentCards);
            }

            command = console.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> pair : personCards.entrySet()) {
            int score = 0;

            for (String card : pair.getValue()) {
                String power = card.substring(0, card.length() - 1);
                String type = card.substring(card.length() - 1);

                int powerInt = 0;
                int multiplier = 0;

                if (power.equals("J")) {
                    powerInt = 11;
                } else if (power.equals("Q")) {
                    powerInt = 12;
                } else if (power.equals("K")) {
                    powerInt = 13;
                } else if (power.equals("A")) {
                    powerInt = 14;
                } else {
                    powerInt = Integer.parseInt(power);
                }

                if (type.equals("S")) {
                    multiplier = 4;
                } else if (type.equals("H")) {
                    multiplier = 3;
                } else if (type.equals("D")) {
                    multiplier = 2;
                } else if (type.equals("C")) {
                    multiplier = 1;
                }

                score += powerInt * multiplier;
            }

            System.out.printf("%s: %d%n", pair.getKey(), score);
        }
    }
}
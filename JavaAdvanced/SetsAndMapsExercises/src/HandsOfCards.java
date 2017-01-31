import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        LinkedHashMap<String, HashSet<String>> personCards = new LinkedHashMap<>();

        while (!command.equals("JOKER")) {
            String[] split = command.split(": ");

            String personName = split[0];
            String[] cards = split[1].split(", ");

            if (!personCards.containsKey(personName)) {
                HashSet<String> cardsDistinct = new HashSet<>();

                for (String card : cards) {
                    cardsDistinct.add(card);
                }

                personCards.put(personName, cardsDistinct);
            } else {
                for (String card : cards) {
                    personCards.get(personName).add(card);
                }
            }

            command = console.nextLine();
        }

        for (String person : personCards.keySet()) {

            int sum = 0;

            for (String card : personCards.get(person)) {
                String power = card.substring(0, card.length() - 1);
                String type = Character.toString(card.charAt(card.length() - 1));

                switch (power) {
                    case "J":
                        power = "11";
                        break;

                    case "Q":
                        power = "12";
                        break;

                    case "K":
                        power = "13";
                        break;

                    case "A":
                        power = "14";
                        break;
                }

                switch (type) {
                    case "S":
                        type = "4";
                        break;

                    case "H":
                        type = "3";
                        break;

                    case "D":
                        type = "2";
                        break;

                    case "C":
                        type = "1";
                        break;
                }

                sum += Integer.parseInt(power) * Integer.parseInt(type);
            }

            System.out.printf("%s: %d%n", person, sum);
        }
    }
}
package handScore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] cardsTokens = reader.readLine().split(" ");

        String lastSuit = null;
        int suitStreak = 1;
        int streakSum = 0;
        int sum = 0;

        for (String cardTokens : cardsTokens) {
            String cardFace;

            if (cardTokens.length() == 2) {
                cardFace = Character.toString(cardTokens.charAt(0));
            } else {
                cardFace = cardTokens.substring(0, cardTokens.length() - 1); //TODO Might be wrong
            }

            String cardSuit = Character.toString(cardTokens.charAt(cardTokens.length() - 1));
            int cardPower = getCardPowerFromFace(cardFace);

            if (lastSuit == null) {
                lastSuit = cardSuit;
                streakSum += cardPower;
            } else if (lastSuit.equals(cardSuit)) {
                suitStreak++;
                streakSum += cardPower;
            } else {
                if (streakSum != 0) {
                    sum += (streakSum * suitStreak);
                    suitStreak = 1;
                    streakSum = 0;
                }

                streakSum += cardPower;
                lastSuit = cardSuit;
            }

            if (cardTokens.equals(cardsTokens[cardsTokens.length - 1])) {
                sum += (streakSum * suitStreak);
            }
        }

        System.out.println(sum);
    }

    private static int getCardPowerFromFace(String cardFace) {
        int power = 0;

        switch (cardFace) {
            case "J":
                power = 12;
                break;
            case "Q":
                power = 13;
                break;
            case "K":
                power = 14;
                break;
            case "A":
                power = 15;
                break;
            default:
                power = Integer.parseInt(cardFace);
                break;
        }

        return power;
    }
}
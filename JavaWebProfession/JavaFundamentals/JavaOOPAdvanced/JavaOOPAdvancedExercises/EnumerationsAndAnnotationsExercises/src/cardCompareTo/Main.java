package cardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank = reader.readLine();
        String suit = reader.readLine();

        Card cardOne = new Card(rank, suit);

        rank = reader.readLine();
        suit = reader.readLine();

        Card cardTwo = new Card(rank, suit);

        if (cardOne.compareTo(cardTwo) > 0) {
            System.out.println(cardOne);
        } else {
            System.out.println(cardTwo);
        }
    }
}
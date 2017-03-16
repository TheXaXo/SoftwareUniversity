package Mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" \\| ");

        switch (tokens[1]) {
            case "Demon":
                GameObject demon = new Demon
                        (tokens[0], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[2]));
                System.out.println(String.format("\"%s\" | \"%s\" -> Demon", demon.getUserName(), demon.getHashedPassword()));
                System.out.println(demon.getSpecialPoints() * demon.getLevel());

                break;
            case "Archangel":
                GameObject archangel = new Archangel
                        (tokens[0], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[2]));
                System.out.println(String.format("\"%s\" | \"%s\" -> Archangel", archangel.getUserName(), archangel.getHashedPassword()));
                System.out.println((int) (archangel.getSpecialPoints() * archangel.getLevel()));

                break;
        }
    }
}
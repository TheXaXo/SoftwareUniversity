package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        ArrayList<Cat> cats = new ArrayList<>();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            String type = tokens[0];
            String name = tokens[1];

            switch (type) {
                case "Siamese":
                    SiameseCat catSiamese = new SiameseCat(name, Double.parseDouble(tokens[2]));
                    cats.add(catSiamese);
                    break;

                case "Cymric":
                    CymricCat catCymric = new CymricCat(name, Double.parseDouble(tokens[2]));
                    cats.add(catCymric);
                    break;

                case "StreetExtraordinaire":
                    StreetExtraordinaireCat catStreetExtra = new StreetExtraordinaireCat(name, Integer.parseInt(tokens[2]));
                    cats.add(catStreetExtra);
                    break;
            }

            command = reader.readLine();
        }

        String catToPrint = reader.readLine();

        cats.stream()
                .filter(cat -> cat.getName().equals(catToPrint))
                .limit(1)
                .forEach(cat -> System.out.println(cat));
    }
}
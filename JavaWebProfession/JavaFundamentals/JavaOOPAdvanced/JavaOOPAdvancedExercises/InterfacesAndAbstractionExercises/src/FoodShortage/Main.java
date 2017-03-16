package FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<BaseEntry> buyers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            if (tokens.length == 4) {
                BaseEntry citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                buyers.add(citizen);
            } else {
                BaseEntry rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                buyers.add(rebel);
            }
        }

        String command = reader.readLine();

        while (!command.equals("End")) {
            String name = command;

            buyers.stream()
                    .filter(entry -> entry.getName().equals(name))
                    .limit(1)
                    .forEach(Buyer::buyFood);

            command = reader.readLine();
        }

        System.out.println(buyers.stream()
                .mapToInt(BaseEntry::getFood)
                .sum());
    }
}
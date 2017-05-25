package BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Birthable> birthables = new ArrayList<>();

        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Pet":
                    Birthable pet = new Pet(tokens[1], tokens[2]);
                    birthables.add(pet);
                    break;
                case "Citizen":
                    Birthable citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    birthables.add(citizen);
                    break;
            }

            command = reader.readLine();
        }

        String yearToCheck = reader.readLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthdate().endsWith(yearToCheck)) {
                System.out.println(birthable.getBirthdate());
            }
        }
    }
}
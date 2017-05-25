package PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] commandTokens = reader.readLine().split(" ");

            switch (commandTokens[0]) {
                case "Create":
                    if (commandTokens[1].equals("Pet")) {
                        pets.put(commandTokens[2],
                                new Pet(commandTokens[2], Integer.parseInt(commandTokens[3]), commandTokens[4]));
                    } else {
                        try {
                            Clinic clinic = new Clinic(commandTokens[2], Integer.parseInt(commandTokens[3]));
                            clinics.put(commandTokens[2], clinic);
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }

                    break;
                case "Add":
                    Pet petToAdd = pets.get(commandTokens[1]);
                    System.out.println(clinics.get(commandTokens[2]).add(petToAdd));

                    break;
                case "Release":
                    System.out.println(clinics.get(commandTokens[1]).release());

                    break;
                case "Print":
                    if (commandTokens.length == 2) {
                        clinics.get(commandTokens[1]).print();
                    } else {
                        clinics.get(commandTokens[1]).print(Integer.parseInt(commandTokens[2]) - 1);
                    }

                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(commandTokens[1]).hasEmptyRooms());

                    break;
            }
        }
    }
}
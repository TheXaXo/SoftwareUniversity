package BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Identifiable> identifiables = new ArrayList<>();

        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            if (tokens.length == 3) {
                Identifiable citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                identifiables.add(citizen);
            } else {
                Identifiable robot = new Robot(tokens[0], tokens[1]);
                identifiables.add(robot);
            }

            command = reader.readLine();
        }

        String idToCheck = reader.readLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(idToCheck)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
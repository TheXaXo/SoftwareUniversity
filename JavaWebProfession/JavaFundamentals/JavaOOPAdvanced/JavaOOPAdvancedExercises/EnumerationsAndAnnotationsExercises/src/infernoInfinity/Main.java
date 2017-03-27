package infernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        Map<String, Weapon> nameWeapon = new LinkedHashMap<>();

        while (!command.equals("END")) {
            String[] tokens = command.split(";");

            switch (tokens[0]) {
                case "Create":
                    String type = tokens[1];
                    String name = tokens[2];

                    Weapon weapon = Weapon.valueOf(type);
                    weapon.setName(name);

                    nameWeapon.put(name, weapon);

                    break;
                case "Add":
                    name = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    String gemType = tokens[3];

                    Gem gem = Gem.valueOf(gemType);

                    try {
                        nameWeapon.get(name).add(gem, index);
                    } catch (IllegalArgumentException ex) {
                        break;
                    }

                    break;
                case "Remove":
                    name = tokens[1];
                    index = Integer.parseInt(tokens[2]);

                    try {
                        nameWeapon.get(name).remove(index);
                    } catch (IllegalArgumentException ex) {
                        break;
                    }

                    break;
                case "Print":
                    name = tokens[1];

                    System.out.println(nameWeapon.get(name));

                    break;
            }

            command = reader.readLine();
        }
    }
}
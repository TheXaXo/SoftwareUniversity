package infernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        WeaponManager manager = new WeaponManager();

        CustomAnnotation annotation = Weapon.class.getDeclaredAnnotation(CustomAnnotation.class);

        while (!command.equals("END")) {
            String[] tokens = command.split(";");

            if (tokens.length == 1) {
                if (tokens[0].equals("Description")) {
                    tokens[0] = "Class description";
                }

                System.out.print(tokens[0] + ": ");

                switch (tokens[0]) {
                    case "Author":
                        System.out.println(annotation.author());
                        break;
                    case "Revision":
                        System.out.println(annotation.revision());
                        break;
                    case "Class description":
                        System.out.println(annotation.description());
                        break;
                    case "Reviewers":
                        System.out.println(String.join(", ", Arrays.asList(annotation.reviewers())));
                        break;
                }

                command = reader.readLine();
                continue;
            }

            switch (tokens[0]) {
                case "Create":
                    manager.create(tokens[1], tokens[2]);
                    break;
                case "Add":
                    manager.add(tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
                    break;
                case "Remove":
                    manager.remove(tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case "Print":
                    manager.print(tokens[1]);
                    break;
                case "Compare":
                    manager.compare(tokens[1], tokens[2]);
                    break;
            }

            command = reader.readLine();
        }
    }
}
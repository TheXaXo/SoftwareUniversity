import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = reader.readLine();

        BiPredicate<String, String[]> predicate = (name, commandSplit) -> {
            String criteria = commandSplit[1];
            String expression = commandSplit[2];

            if (criteria.equals("StartsWith")) {
                if (name.startsWith(expression)) {
                    return true;
                }
            } else if (criteria.equals("EndsWith")) {
                if (name.endsWith(expression)) {
                    return true;
                }
            } else {
                if (name.length() == Integer.parseInt(expression)) {
                    return true;
                }
            }

            return false;
        };

        while (!command.equals("Party!")) {
            String[] commandArgs = command.split(" ");

            if (commandArgs[0].equals("Remove")) {

                people.removeIf(person -> predicate.test(person, commandArgs));
            } else {
                ArrayList<String> originalPeople = new ArrayList<>();

                for (String person : people) {
                    originalPeople.add(person);
                }

                for (int i = 0; i < originalPeople.size(); i++) {
                    if (predicate.test(originalPeople.get(i), commandArgs)) {
                        people.add(originalPeople.get(i));
                    }
                }
            }

            command = reader.readLine();
        }

        if (people.size() == 0) {
            System.out.println("Nobody is going to the party!");
            return;
        }

        StringBuilder output = new StringBuilder();

        for (String name : people) {
            output.append(name).append(", ");
        }

        String outputStr = output.substring(0, output.length() - 2);

        System.out.printf("%s are going to the party!", outputStr);
    }
}
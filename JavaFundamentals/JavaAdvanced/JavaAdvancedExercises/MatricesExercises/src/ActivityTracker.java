import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ActivityTracker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern p = Pattern.compile("[0-9]+\\/([0-9]+)\\/[0-9]+ (.+?) (.+)");

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<Integer, ArrayList<Person>> monthSteps = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            Matcher m = p.matcher(reader.readLine());

            if (!m.matches()) {
                continue;
            }

            int month = Integer.parseInt(m.group(1));

            Person person = new Person();
            person.name = m.group(2);
            person.distance = Double.parseDouble(m.group(3));

            if (!monthSteps.containsKey(month)) {
                ArrayList<Person> persons = new ArrayList<>();
                persons.add(person);

                monthSteps.put(month, persons);
            } else {
                if (!monthSteps.get(month).stream().anyMatch(a -> a.name.equals(person.name))) {
                    monthSteps.get(month).add(person);
                } else {
                    ArrayList<Person> persons = monthSteps.get(month);

                    for (int j = 0; j < persons.size(); j++) {
                        if (persons.get(j).name.equals(person.name)) {
                            persons.get(j).distance += person.distance;
                        }
                    }
                }
            }

        }

        ArrayList<Map.Entry<Integer, ArrayList<Person>>> monthsOrdered = monthSteps.entrySet().stream()
                .sorted(Comparator.comparingInt(a -> a.getKey()))
                .collect(Collectors.toCollection(ArrayList::new));

        for (Map.Entry<Integer, ArrayList<Person>> pair : monthsOrdered) {
            ArrayList<Person> persons = pair.getValue();

            System.out.printf("%d: ", pair.getKey());

            persons = persons.stream()
                    .sorted(Comparator.comparing(a -> a.name))
                    .collect(Collectors.toCollection(ArrayList::new));

            for (int j = 0; j < persons.size(); j++) {
                System.out.printf("%s(%.0f)", persons.get(j).name, persons.get(j).distance);

                if (j == persons.size() - 1) {
                    System.out.println();
                } else {
                    System.out.print(", ");
                }
            }
        }
    }
}

class Person {
    String name;
    double distance;
}
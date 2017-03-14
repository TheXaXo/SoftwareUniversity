import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalAccounting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        Pattern p = Pattern.compile("([A-Za-z]+);(\\d+);(\\d+(?:\\.\\d+)?);([A-Za-z]+)");

        LinkedHashMap<String, LinkedHashSet<Person>> teamMembers = new LinkedHashMap<>();

        while (!command.equals("Pishi kuf i da si hodim")) {
            Matcher m = p.matcher(command);

            if (!m.matches()) {
                command = reader.readLine();
                continue;
            }

            String team = m.group(4);
            String name = m.group(1);
            int workHours = Integer.parseInt(m.group(2));
            double dailyIncome = Double.parseDouble(m.group(3));

            Person person = new Person();
            person.name = name;
            person.workHours = workHours;
            person.dailyIncome = dailyIncome;

            if (!teamMembers.containsKey(team)) {
                teamMembers.put(team, new LinkedHashSet<>());

                teamMembers.get(team).add(person);
            } else {
                if (!teamMembers.get(team).contains(person)) {
                    teamMembers.get(team).add(person);
                }
            }

            command = reader.readLine();
        }

        teamMembers.entrySet().stream()
                .sorted((a, b) -> {
                    LinkedHashSet<Person> aMembers = a.getValue();
                    LinkedHashSet<Person> bMembers = b.getValue();

                    Double aMoney = 0d;
                    Double bMoney = 0d;

                    for (Person member : aMembers) {
                        aMoney += (((long) member.dailyIncome * member.workHours) / 24d) * 30d;
                    }

                    for (Person member : bMembers) {
                        bMoney += (((long) member.dailyIncome * member.workHours) / 24d) * 30d;
                    }

                    return bMoney.compareTo(aMoney);
                })
                .forEach(pair -> {
                    System.out.println("Team - " + pair.getKey());

                    pair.getValue().stream()
                            .sorted(Comparator.<Person>comparingInt(a -> a.workHours)
                                    .reversed()
                                    .thenComparingDouble(a -> ((long) a.dailyIncome * a.workHours) / 24d)
                                    .reversed()
                                    .thenComparing(a -> a.name))
                            .forEach(people -> System.out.printf("$$$%s - %d - %.6f%n", people.name, people.workHours, people.dailyIncome));
                });
    }
}

class Person {
    String name;
    int workHours;
    double dailyIncome;
}
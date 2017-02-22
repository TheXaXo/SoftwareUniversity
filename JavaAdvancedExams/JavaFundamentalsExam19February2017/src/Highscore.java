import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        LinkedHashMap<String, Long> personScore = new LinkedHashMap<>();
        HashMap<String, ArrayList<Duel>> personDuels = new HashMap<>();

        Pattern p = Pattern.compile("(\\d+) ([a-zA-Z\\d]+)<->([a-zA-Z\\d]+) (\\d+)");

        while (!command.equals("osu!")) {
            Matcher m = p.matcher(command);

            if (!m.matches()) {
                command = reader.readLine();
                continue;
            }

            String person1 = m.group(2);
            long person1Score = Long.parseLong(m.group(1));

            String person2 = m.group(3);
            long person2Score = Long.parseLong(m.group(4));

            if (!personScore.containsKey(person1)) {
                personScore.put(person1, person1Score - person2Score);
                Duel duel = new Duel();

                duel.opponent = person2;
                duel.scoreGainedOrLost = person1Score - person2Score;

                personDuels.put(person1, new ArrayList<>());
                personDuels.get(person1).add(duel);
            } else {
                personScore.put(person1, personScore.get(person1) + (person1Score - person2Score));

                Duel duel = new Duel();

                duel.opponent = person2;
                duel.scoreGainedOrLost = person1Score - person2Score;

                personDuels.get(person1).add(duel);
            }

            if (!personScore.containsKey(person2)) {
                personScore.put(person2, person2Score - person1Score);
                Duel duel = new Duel();

                duel.opponent = person1;
                duel.scoreGainedOrLost = person2Score - person1Score;

                personDuels.put(person2, new ArrayList<>());
                personDuels.get(person2).add(duel);
            } else {
                personScore.put(person2, personScore.get(person2) + (person2Score - person1Score));

                Duel duel = new Duel();

                duel.opponent = person1;
                duel.scoreGainedOrLost = person2Score - person1Score;

                personDuels.get(person2).add(duel);
            }

            command = reader.readLine();
        }

        personScore.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                        .reversed())
                .forEach(pair -> {
                    System.out.printf("%s - (%d)%n", pair.getKey(), pair.getValue());

                    personDuels.get(pair.getKey())
                            .forEach(duel -> {
                                System.out.printf("*   %s <-> %d%n", duel.opponent, duel.scoreGainedOrLost);
                            });
                });
    }
}

class Duel {
    String opponent;
    long scoreGainedOrLost;
}
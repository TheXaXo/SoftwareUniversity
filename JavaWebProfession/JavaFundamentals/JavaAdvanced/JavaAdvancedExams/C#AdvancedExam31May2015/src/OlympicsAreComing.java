import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class OlympicsAreComing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        LinkedHashMap<String, ArrayList<String>> countryPersons = new LinkedHashMap<>();

        while (!command.equals("report")) {
            String[] tokens = command.replaceAll("\\s+", " ").trim().split("\\|");

            String person = tokens[0].trim();
            String country = tokens[1].trim();

            if (!countryPersons.containsKey(country)) {
                countryPersons.put(country, new ArrayList<>());
            }

            countryPersons.get(country).add(person);

            command = reader.readLine();
        }

        countryPersons.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, ArrayList<String>>>
                        comparingInt(pair -> pair.getValue().size())
                        .reversed())
                .forEach(pair -> {
                    int wins = pair.getValue().size();
                    long participants = pair.getValue().stream().distinct().count();

                    System.out.printf("%s (%d participants): %d wins%n", pair.getKey(), participants, wins);
                });
    }
}
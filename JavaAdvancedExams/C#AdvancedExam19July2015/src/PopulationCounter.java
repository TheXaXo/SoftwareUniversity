import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> countryCities = new LinkedHashMap<>();

        while (!command.equals("report")) {
            String[] tokens = command.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!countryCities.containsKey(country)) {
                countryCities.put(country, new LinkedHashMap<>());

                countryCities.get(country).put(city, population);
            } else {
                if (!countryCities.get(country).containsKey(city)) {
                    countryCities.get(country).put(city, population);
                } else {
                    countryCities.get(country).put(city, countryCities.get(country).get(city) + population);
                }
            }

            command = reader.readLine();
        }

        countryCities.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, LinkedHashMap<String, Long>>>
                        comparingLong(pair -> pair.getValue().values().stream().mapToLong(a -> a).sum())
                        .reversed())
                .forEach(pair -> {
                    long totalPopulation = pair.getValue().values().stream().mapToLong(a -> a).sum();

                    System.out.printf("%s (total population: %d)%n", pair.getKey(), totalPopulation);

                    pair.getValue().entrySet().stream()
                            .sorted(Comparator.<Map.Entry<String, Long>>
                                    comparingLong(Map.Entry::getValue)
                                    .reversed())
                            .forEach(innerPair -> {
                                System.out.printf("=>%s: %d%n", innerPair.getKey(), innerPair.getValue());
                            });
                });
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> countryCities = new LinkedHashMap<>();

        while (!command.equals("report")) {
            String[] inputArgs = command.split("\\|");

            String city = inputArgs[0];
            String country = inputArgs[1];
            long population = Long.parseLong(inputArgs[2]);

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

        ArrayList<Map.Entry<String, LinkedHashMap<String, Long>>> countryCitiesOrdered =
                countryCities.entrySet().stream()
                        .sorted(Comparator.<Map.Entry<String, LinkedHashMap<String, Long>>>comparingLong
                                (a -> a.getValue().values().stream().mapToLong(b -> b).sum()).reversed())
                        .collect(Collectors.toCollection(ArrayList::new));

        for (Map.Entry<String, LinkedHashMap<String, Long>> pair : countryCitiesOrdered) {

            ArrayList<Map.Entry<String, Long>> cityPopulation = pair.getValue().entrySet().stream()
                    .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(a -> a.getValue()).reversed())
                    .collect(Collectors.toCollection(ArrayList::new));

            long totalPopulation = cityPopulation.stream().mapToLong(a -> a.getValue()).sum();

            System.out.printf("%s (total population: %d)%n", pair.getKey(), totalPopulation);

            for (Map.Entry<String, Long> cityPopulationPair : cityPopulation) {
                System.out.printf("=>%s: %d%n", cityPopulationPair.getKey(), cityPopulationPair.getValue());
            }
        }
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> countryCities = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] inputArgs = input.split("\\|");

            String city = inputArgs[0];
            String country = inputArgs[1];
            int population = Integer.parseInt(inputArgs[2]);

            if (!countryCities.containsKey(country)) {
                LinkedHashMap<String, Long> cityPopulation = new LinkedHashMap<>();
                cityPopulation.put(city, (long) population);

                countryCities.put(country, cityPopulation);
            } else {
                LinkedHashMap<String, Long> cities = countryCities.get(country);

                if (!cities.containsKey(city)) {
                    cities.put(city, (long) population);
                } else {
                    cities.put(city, cities.get(city) + population);
                }
            }

            input = console.nextLine();
        }

        ArrayList<Map.Entry<String, LinkedHashMap<String, Long>>> countriesOrdered =
                countryCities.entrySet().stream()
                        .sorted(Comparator.<Map.Entry<String, LinkedHashMap<String, Long>>>comparingLong
                                (a -> a.getValue().values().stream().mapToLong(b -> b).sum()).reversed())
                        .collect(Collectors.toCollection(ArrayList::new));

        for (Map.Entry<String, LinkedHashMap<String, Long>> countriesOrderedPair : countriesOrdered) {
            String country = countriesOrderedPair.getKey();

            ArrayList<Map.Entry<String, Long>> citiesPairOrdered = countriesOrderedPair.getValue().entrySet().stream()
                    .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(a -> a.getValue()).reversed())
                    .collect(Collectors.toCollection(ArrayList::new));

            long totalPopulation = citiesPairOrdered.stream().mapToLong(a -> a.getValue()).sum();

            System.out.printf("%s (total population: %d)%n", country, totalPopulation);

            for (Map.Entry<String, Long> citiesPair : citiesPairOrdered) {
                System.out.printf("=>%s: %d%n", citiesPair.getKey(), citiesPair.getValue());
            }
        }
    }
}
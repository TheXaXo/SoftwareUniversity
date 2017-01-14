import java.util.*;

public class TestProgram5 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> countryCities = new LinkedHashMap<>();

        while (!command.equals("report")) {
            String[] inputArgs = command.split("\\|");

            String city = inputArgs[0];
            String country = inputArgs[1];
            long population = Long.parseLong(inputArgs[2]);

            if (!countryCities.containsKey(country)) {
                LinkedHashMap<String, Long> cityPopulation = new LinkedHashMap<>();
                cityPopulation.put(city, population);

                countryCities.put(country, cityPopulation);
            } else {
                LinkedHashMap<String, Long> cityPopulationOfCurrent = countryCities.get(country);

                if (cityPopulationOfCurrent.containsKey(city)) {
                    cityPopulationOfCurrent.put(city, cityPopulationOfCurrent.get(city) + population);
                } else {
                    cityPopulationOfCurrent.put(city, population);
                }

                countryCities.put(country, cityPopulationOfCurrent);
            }

            command = console.nextLine();
        }

        ArrayList<Map.Entry<String, LinkedHashMap<String, Long>>> countryCitiesList = new ArrayList<>(countryCities.entrySet());
        countryCitiesList.sort((a, b) -> Long.compare(b.getValue().values().stream().mapToLong(i -> i).sum(),
                a.getValue().values().stream().mapToLong(i -> i).sum()));

        for (Map.Entry<String, LinkedHashMap<String, Long>> countryCitiesPair : countryCitiesList) {
            long totalPopulation = countryCitiesPair.getValue()
                    .values()
                    .stream()
                    .mapToLong(i -> i)
                    .sum();

            System.out.printf("%s (total population: %d)", countryCitiesPair.getKey(), totalPopulation);
            System.out.println();

            LinkedHashMap<String, Long> cityPopulation = countryCitiesPair.getValue();

            ArrayList<Map.Entry<String, Long>> cityPopulationList = new ArrayList<>(cityPopulation.entrySet());
            cityPopulationList.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));

            for (Map.Entry<String, Long> cityPopulationPair : cityPopulationList) {
                System.out.printf("=>%s: %d", cityPopulationPair.getKey(), cityPopulationPair.getValue());
                System.out.println();
            }
        }
    }
}
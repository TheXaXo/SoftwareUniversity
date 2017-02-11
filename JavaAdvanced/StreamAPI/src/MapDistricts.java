import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        HashMap<String, ArrayList<Integer>> cityDistricts = new HashMap<>();

        for (String token : tokens) {
            String[] pair = token.split(":");

            String city = pair[0];
            int population = Integer.parseInt(pair[1]);

            if (!cityDistricts.containsKey(city)) {
                cityDistricts.put(city, new ArrayList<>());

                cityDistricts.get(city).add(population);
            } else {
                cityDistricts.get(city).add(population);
            }
        }

        int treshold = Integer.parseInt(reader.readLine());

        cityDistricts.entrySet().stream()
                .filter(pair -> {
                    int totalSum = pair.getValue().stream().mapToInt(a -> a).sum();

                    return treshold <= totalSum;
                })
                .sorted(Comparator.<Map.Entry<String, ArrayList<Integer>>>comparingInt
                        (pair -> pair.getValue().stream().mapToInt(a -> a).sum()).reversed())
                .forEach(pair -> {
                    System.out.printf("%s: ", pair.getKey());

                    pair.getValue().stream()
                            .sorted(Comparator.<Integer>comparingInt(b -> b).reversed())
                            .limit(5)
                            .forEach(number -> System.out.print(number + " "));

                    System.out.println();
                });

    }
}
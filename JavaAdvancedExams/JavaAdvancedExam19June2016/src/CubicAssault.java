import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        HashMap<String, HashMap<String, Long>> regionMeteors = new HashMap<>();

        while (!input.equals("Count em all")) {
            String[] tokens = input.split(" -> ");

            String region = tokens[0];
            String meteor = tokens[1];
            long count = Long.parseLong(tokens[2]);

            if (!regionMeteors.containsKey(region)) {
                regionMeteors.put(region, new HashMap<>());

                regionMeteors.get(region).put("Red", 0L);
                regionMeteors.get(region).put("Green", 0L);
                regionMeteors.get(region).put("Black", 0L);
            }

            regionMeteors.get(region).put(meteor, regionMeteors.get(region).get(meteor) + count);

            if (regionMeteors.get(region).get("Green") >= 1000000) {
                regionMeteors.get(region).put("Red", regionMeteors.get(region).get("Green") / 1000000 + regionMeteors.get(region).get("Red"));
                regionMeteors.get(region).put("Green", regionMeteors.get(region).get("Green") % 1000000);
            }

            if (regionMeteors.get(region).get("Red") >= 1000000) {
                regionMeteors.get(region).put("Black", regionMeteors.get(region).get("Red") / 1000000 + regionMeteors.get(region).get("Black"));
                regionMeteors.get(region).put("Red", regionMeteors.get(region).get("Red") % 1000000);
            }

            input = reader.readLine();
        }

        regionMeteors.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, HashMap<String, Long>>>comparingLong(pair -> pair.getValue().get("Black"))
                        .reversed()
                        .thenComparingInt(pair -> pair.getKey().length())
                        .thenComparing(Map.Entry::getKey))
                .forEach(pair -> {
                    System.out.println(pair.getKey());

                    pair.getValue().entrySet().stream()
                            .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                                    .reversed()
                                    .thenComparing(Map.Entry::getKey))
                            .forEach(innerPair -> System.out.printf("-> %s : %d%n", innerPair.getKey(), innerPair.getValue()));
                });
    }
}
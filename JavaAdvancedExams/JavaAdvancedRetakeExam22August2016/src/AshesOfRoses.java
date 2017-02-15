import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern p = Pattern.compile("Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> (\\d+)");

        String command = reader.readLine();

        HashMap<String, HashMap<String, Long>> regionColor = new HashMap<>();

        while (!command.equals("Icarus, Ignite!")) {
            Matcher m = p.matcher(command);

            if (!m.matches()) {
                command = reader.readLine();
                continue;
            }

            String region = m.group(1);
            String color = m.group(2);
            long roseAmount = Long.parseLong(m.group(3));

            if (!regionColor.containsKey(region)) {
                regionColor.put(region, new HashMap<>());

                regionColor.get(region).put(color, roseAmount);
            } else {
                if (regionColor.get(region).containsKey(color)) {
                    regionColor.get(region).put(color, regionColor.get(region).get(color) + roseAmount);
                } else {
                    regionColor.get(region).put(color, roseAmount);
                }
            }

            command = reader.readLine();
        }

        regionColor.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, HashMap<String, Long>>>comparingLong
                        (pair -> pair.getValue().values().stream().mapToLong(a -> a).sum())
                        .reversed()
                        .thenComparing(pair -> pair.getKey()))
                .forEach(pair -> {
                    System.out.println(pair.getKey());

                    pair.getValue().entrySet().stream()
                            .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(innerPair -> innerPair.getValue())
                                    .thenComparing(innerPair -> innerPair.getKey()))
                            .forEach(innerPair -> {
                                System.out.printf("*--%s | %d%n", innerPair.getKey(), innerPair.getValue());
                            });
                });

    }
}
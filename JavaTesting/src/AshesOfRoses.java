import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern p = Pattern.compile("Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> ([0-9]+)");

        String command = reader.readLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> regionColors = new LinkedHashMap<>();

        while (!command.equals("Icarus, Ignite!")) {
            Matcher m = p.matcher(command);

            if (!m.matches()) {
                command = reader.readLine();
                continue;
            }

            String region = m.group(1);
            String color = m.group(2);
            int count = Integer.parseInt(m.group(3));

            if (!regionColors.containsKey(region)) {
                LinkedHashMap<String, Long> colorCount = new LinkedHashMap<>();
                colorCount.put(color, (long) count);

                regionColors.put(region, colorCount);
            } else {
                LinkedHashMap<String, Long> currentRegionColors = regionColors.get(region);

                if (!currentRegionColors.containsKey(color)) {
                    currentRegionColors.put(color, (long) count);
                } else {
                    currentRegionColors.put(color, currentRegionColors.get(color) + (long) count);
                }
            }

            command = reader.readLine();
        }

        regionColors.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, LinkedHashMap<String, Long>>>comparingLong(pair -> pair.getValue().values().stream().mapToLong(a -> a).sum())
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AshesOfRoses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Pattern p = Pattern.compile("Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> ([0-9]+)");

        String command = console.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> regionColors = new LinkedHashMap<>();

        while (!command.equals("Icarus, Ignite!")) {
            Matcher m = p.matcher(command);

            if (!m.matches()) {
                command = console.nextLine();
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

            command = console.nextLine();
        }

        ArrayList<Map.Entry<String, LinkedHashMap<String, Long>>> regionsOrdered = regionColors.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, LinkedHashMap<String, Long>>>
                        comparingLong(a -> a.getValue().values().stream().mapToLong(Number::longValue).sum())
                        .reversed()
                        .thenComparing(a -> a.getKey()))
                .collect(Collectors.toCollection(ArrayList::new));

        for (Map.Entry<String, LinkedHashMap<String, Long>> pair : regionsOrdered) {
            System.out.println(pair.getKey());

            pair.getValue().entrySet().stream()
                    .sorted(Comparator.<Map.Entry<String, Long>>
                            comparingLong(a -> a.getValue())
                            .thenComparing(a -> a.getKey()))
                    .forEach(colorCountPair ->
                            System.out.printf("*--%s | %d%n", colorCountPair.getKey(), colorCountPair.getValue()));
        }
    }
}
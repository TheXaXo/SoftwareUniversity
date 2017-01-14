import java.util.*;

public class CubicAssault {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> regionMeteors = new LinkedHashMap<>();

        while (!input.equals("Count em all")) {
            String[] split = input.split(" -> ");

            String region = split[0];
            String meteor = split[1];
            long count = Long.parseLong(split[2]);

            LinkedHashMap<String, Long> meteorsCount = new LinkedHashMap<>();

            if (!regionMeteors.containsKey(region)) {
                meteorsCount.put("Green", (long) 0);
                meteorsCount.put("Red", (long) 0);
                meteorsCount.put("Black", (long) 0);

                if (meteor.equals("Green")) {
                    meteorsCount.put("Green", count);
                } else if (meteor.equals("Red")) {
                    meteorsCount.put("Red", count);
                } else if (meteor.equals("Black")) {
                    meteorsCount.put("Black", count);
                }

                regionMeteors.put(region, meteorsCount);
            } else {
                meteorsCount = regionMeteors.get(region);

                if (meteor.equals("Green")) {
                    meteorsCount.put("Green", meteorsCount.get("Green") + count);
                } else if (meteor.equals("Red")) {
                    meteorsCount.put("Red", meteorsCount.get("Red") + count);
                } else if (meteor.equals("Black")) {
                    meteorsCount.put("Black", meteorsCount.get("Black") + count);
                }
            }

            input = console.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> pair : regionMeteors.entrySet()) {
            while (pair.getValue().get("Green") >= 1000000) {
                pair.getValue().put("Green", pair.getValue().get("Green") - 1000000);
                pair.getValue().put("Red", pair.getValue().get("Red") + 1);
            }

            while (pair.getValue().get("Red") >= 1000000) {
                pair.getValue().put("Red", pair.getValue().get("Red") - 1000000);
                pair.getValue().put("Black", pair.getValue().get("Black") + 1);
            }
        }

        regionMeteors.entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, LinkedHashMap<String, Long>>>comparingLong(a -> a.getValue().get("Black"))
                        .reversed()
                        .thenComparing(a -> a.getKey().length())
                        .thenComparing(a -> a.getKey()))
                .forEach(pair -> {
                    System.out.println(pair.getKey());

                    pair.getValue().entrySet().stream()
                            .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(a -> a.getValue())
                                    .reversed()
                                    .thenComparing(a -> a.getKey()))
                            .forEach(orderedPair -> System.out.printf("-> %s : %d%n", orderedPair.getKey(), orderedPair.getValue()));
                });
    }
}
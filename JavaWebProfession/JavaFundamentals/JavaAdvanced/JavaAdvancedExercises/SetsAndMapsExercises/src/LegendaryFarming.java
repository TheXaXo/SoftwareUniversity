import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        HashMap<String, Integer> keyMaterials = new HashMap<>();
        TreeMap<String, Integer> junkItems = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        boolean hasBeenFound = false;

        String itemWhoWon = null;

        while (true) {
            String[] inputArgs = console.nextLine().split(" ");

            for (int i = 0; i < inputArgs.length - 1; i += 2) {
                int itemCount = Integer.parseInt(inputArgs[i]);
                String item = inputArgs[i + 1].toLowerCase();

                if (item.equals("shards") || item.equals("fragments") || item.equals("motes")) {
                    keyMaterials.put(item, keyMaterials.get(item) + itemCount);
                } else {
                    if (!junkItems.containsKey(item)) {
                        junkItems.put(item, itemCount);
                    } else {
                        junkItems.put(item, junkItems.get(item) + itemCount);
                    }
                }

                if (keyMaterials.get("shards") >= 250) {
                    itemWhoWon = "shards";
                    keyMaterials.put(itemWhoWon, keyMaterials.get(itemWhoWon) - 250);

                    hasBeenFound = true;
                    break;
                } else if (keyMaterials.get("fragments") >= 250) {
                    itemWhoWon = "fragments";
                    keyMaterials.put(itemWhoWon, keyMaterials.get(itemWhoWon) - 250);

                    hasBeenFound = true;
                    break;
                } else if (keyMaterials.get("motes") >= 250) {
                    itemWhoWon = "motes";
                    keyMaterials.put(itemWhoWon, keyMaterials.get(itemWhoWon) - 250);

                    hasBeenFound = true;
                    break;
                }
            }

            if (hasBeenFound) {
                break;
            }
        }

        if (itemWhoWon.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (itemWhoWon.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        } else {
            System.out.println("Dragonwrath obtained!");
        }

        keyMaterials.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(a -> a.getValue())
                        .reversed()
                        .thenComparing(a -> a.getKey()))
                .forEach(a -> System.out.printf("%s: %d%n", a.getKey(), a.getValue()));

        for (String item : junkItems.keySet()) {
            System.out.printf("%s: %d%n", item, junkItems.get(item));
        }
    }
}
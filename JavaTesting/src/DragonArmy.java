import java.util.*;
import java.util.stream.Collectors;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int count = Integer.parseInt(console.nextLine());

        LinkedHashMap<String, ArrayList<Dragon>> typeDragons = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] split = console.nextLine().split("\\s");

            String type = split[0];
            String name = split[1];

            String damage = split[2];
            String health = split[3];
            String armor = split[4];

            Dragon dragon = new Dragon();
            dragon.name = name;

            if (!damage.equals("null")) {
                dragon.damage = Integer.parseInt(damage);
            }
            if (!health.equals("null")) {
                dragon.health = Integer.parseInt(health);
            }
            if (!armor.equals("null")) {
                dragon.armor = Integer.parseInt(armor);
            }

            if (!typeDragons.containsKey(type)) {
                typeDragons.put(type, new ArrayList<>(Arrays.asList(dragon)));
            } else {
                boolean containsSameDragon = typeDragons.get(type).stream()
                        .anyMatch(a -> a.name.equals(dragon.name));

                if (containsSameDragon) {
                    Dragon dragonToBeReplaced = typeDragons.get(type).stream()
                            .filter(a -> a.name.equals(dragon.name))
                            .findFirst()
                            .orElse(null);

                    dragonToBeReplaced.damage = dragon.damage;
                    dragonToBeReplaced.health = dragon.health;
                    dragonToBeReplaced.armor = dragon.armor;
                } else {
                    typeDragons.get(type).add(dragon);
                }
            }
        }

        for (Map.Entry<String, ArrayList<Dragon>> pair : typeDragons.entrySet()) {
            double averageDamage = pair.getValue().stream()
                    .mapToInt(a -> a.damage)
                    .average()
                    .orElse(0);

            double averageHealth = pair.getValue().stream()
                    .mapToInt(a -> a.health)
                    .average()
                    .orElse(0);

            double averageArmor = pair.getValue().stream()
                    .mapToInt(a -> a.armor)
                    .average()
                    .orElse(0);

            ArrayList<Dragon> dragonsSorted = pair.getValue().stream()
                    .sorted(Comparator.comparing(a -> a.name))
                    .collect(Collectors.toCollection(ArrayList::new));

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", pair.getKey(), averageDamage, averageHealth, averageArmor);

            for (Dragon currentDragon : dragonsSorted) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        currentDragon.name, currentDragon.damage, currentDragon.health, currentDragon.armor);
            }
        }
    }
}

class Dragon {
    String name;
    int damage = 45;
    int health = 250;
    int armor = 10;
}
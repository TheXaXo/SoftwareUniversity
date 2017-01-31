import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        LinkedHashMap<String, ArrayList<Dragon>> typeDragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] splitArgs = console.nextLine().split(" ");

            String type = splitArgs[0];
            String dragonName = splitArgs[1];

            String damage = splitArgs[2];
            String health = splitArgs[3];
            String armor = splitArgs[4];

            Dragon dragon = new Dragon();
            dragon.name = dragonName;

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
                typeDragons.put(type, new ArrayList<>());

                typeDragons.get(type).add(dragon);
            } else {
                if (typeDragons.get(type).stream().anyMatch(a -> a.name.equals(dragonName))) {
                    Dragon dragonToUpdate = null;

                    for (Dragon dragonToFind : typeDragons.get(type)) {
                        if (dragonToFind.name.equals(dragonName)) {
                            dragonToUpdate = dragonToFind;
                        }
                    }

                    dragonToUpdate.armor = dragon.armor;
                    dragonToUpdate.health = dragon.health;
                    dragonToUpdate.damage = dragon.damage;
                } else {
                    typeDragons.get(type).add(dragon);
                }
            }
        }

        for (String type : typeDragons.keySet()) {
            double averageDamage = typeDragons.get(type).stream().mapToInt(a -> a.damage).average().orElse(0);
            double averageHealth = typeDragons.get(type).stream().mapToInt(a -> a.health).average().orElse(0);
            double averageArmor = typeDragons.get(type).stream().mapToInt(a -> a.armor).average().orElse(0);

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averageDamage, averageHealth, averageArmor);

            typeDragons.get(type).stream()
                    .sorted(Comparator.comparing(a -> a.name))
                    .forEach(a -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", a.name, a.damage, a.health, a.armor));
        }
    }
}

class Dragon {
    String name;
    int health = 250;
    int damage = 45;
    int armor = 10;
}
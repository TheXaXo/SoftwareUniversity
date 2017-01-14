import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] demons = Arrays.stream(console.nextLine().split(","))
                .map(String::trim)
                .toArray(String[]::new);

        ArrayList<Demon> allDemons = new ArrayList<>();

        Pattern healthP = Pattern.compile("[^0-9+\\-\\*\\/\\.]");
        Pattern damageP = Pattern.compile("([+-])*([0-9]+(?:\\.[0-9]+)*)");

        for (String demon : demons) {
            Demon currentDemon = new Demon();

            currentDemon.name = demon;

            Matcher healthM = healthP.matcher(demon);
            Matcher damageM = damageP.matcher(demon);

            while (healthM.find()) {
                currentDemon.health += healthM.group(0).charAt(0);
            }

            while (damageM.find()) {
                double damage = Double.parseDouble(damageM.group(2));

                if (damageM.group(1) != null && damageM.group(1).equals("-")) {
                    damage = damage / -1;
                }

                currentDemon.damage += damage;
            }

            for (char c : demon.toCharArray()) {
                if (c == '*') {
                    currentDemon.damage *= 2;
                } else if (c == '/') {
                    currentDemon.damage /= 2;
                }
            }

            allDemons.add(currentDemon);
        }

        allDemons.stream()
                .sorted(Comparator.comparing(a -> a.name))
                .forEach(a -> System.out.printf("%s - %d health, %.2f damage%n",
                        a.name, a.health, a.damage));
    }
}

class Demon {
    String name;
    int health = 0;
    double damage = 0;
}
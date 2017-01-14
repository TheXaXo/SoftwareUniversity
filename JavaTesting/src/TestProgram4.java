import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestProgram4 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] demons = console.nextLine()
                .split(",|\\s");

        demons = Arrays.stream(demons)
                .filter(d -> d.length() > 0)
                .toArray(String[]::new);

        TreeMap<String, LinkedHashMap<Integer, Double>> nameParams = new TreeMap<>();

        for (String demon : demons) {
            int health = 0;
            double damage = 0;

            String healthPattern = "[^\\d\\+\\-\\*\\/\\.]";
            String damagePattern = "[+-]*\\d[.\\d]*";

            Pattern pHealth = Pattern.compile(healthPattern);
            Pattern pDamage = Pattern.compile(damagePattern);

            Matcher mHealth = pHealth.matcher(demon);
            Matcher mDamage = pDamage.matcher(demon);

            while (mHealth.find()) {
                health += (int) mHealth.group().charAt(0);
            }

            while (mDamage.find()) {
                String numberStr = mDamage.group();

                if (numberStr.charAt(0) == '+') {
                    damage += Double.parseDouble(numberStr.substring(1));
                } else if (numberStr.charAt(0) == '-') {
                    damage -= Double.parseDouble(numberStr.substring(1));
                } else {
                    damage += Double.parseDouble(numberStr);
                }
            }

            for (char c : demon.toCharArray()) {
                if (c == '*') {
                    damage *= 2;
                } else if (c == '/') {
                    damage /= 2;
                }
            }

            LinkedHashMap<Integer, Double> healthDamage = new LinkedHashMap<>();
            healthDamage.put(health, damage);

            nameParams.put(demon, healthDamage);
        }

        for (Map.Entry<String, LinkedHashMap<Integer, Double>> pair : nameParams.entrySet()) {
            LinkedHashMap<Integer, Double> currentHealthDamage = pair.getValue();
            Map.Entry<Integer, Double> healthDamagePair = currentHealthDamage.entrySet().iterator().next();

            System.out.printf("%s - %d health, %.2f damage", pair.getKey(), healthDamagePair.getKey(), healthDamagePair.getValue());
            System.out.println();
        }
    }
}
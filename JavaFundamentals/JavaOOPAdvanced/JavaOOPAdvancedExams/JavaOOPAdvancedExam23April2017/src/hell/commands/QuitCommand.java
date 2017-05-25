package hell.commands;

import hell.interfaces.Hero;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuitCommand extends BaseCommand {

    public QuitCommand(String[] tokens, Map<String, Hero> heroes) {
        super(tokens, heroes);
    }

    @Override
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        StringBuilder out = new StringBuilder();
        int count = 1;

        List<Hero> heroes = new ArrayList<>(super.getHeroes().values());
        heroes = heroes.stream()
                .sorted((a, b) -> {
                    int result = 0;

                    result = Long.compare(b.getStrength() + b.getAgility() + b.getIntelligence(),
                            a.getStrength() + a.getAgility() + a.getIntelligence());

                    if (result == 0) {
                        result = Long.compare(b.getHitPoints() + b.getDamage(),
                                a.getHitPoints() + a.getDamage());
                    }

                    return result;
                })
                .collect(Collectors.toList());

        int processedHeroes = 0;

        for (Hero hero : heroes) {
            out.append(count++).append(". ").append(hero.toString());
            processedHeroes++;

            if (processedHeroes < heroes.size()) {
                out.append("\n");
            }
        }

        return out.toString();
    }
}
package hell.commands;

import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InspectCommand extends BaseCommand {

    public InspectCommand(String[] tokens, Map<String, Hero> heroes) {
        super(tokens, heroes);
    }

    @Override
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String heroName = super.getTokens()[1];

        Hero hero = super.getHeroes().get(heroName);

        StringBuilder out = new StringBuilder();
        out.append(String.format(
                "Hero: %s, Class: %s\n" +
                        "HitPoints: %d, Damage: %d\n" +
                        "Strength: %d\n" +
                        "Agility: %d\n" +
                        "Intelligence: %d\n",
                hero.getName(),
                hero.getClass().getSimpleName(),
                hero.getHitPoints(),
                hero.getDamage(),
                hero.getStrength(),
                hero.getAgility(),
                hero.getIntelligence()));

        List<Item> heroItems = new ArrayList<>(hero.getItems());

        if (heroItems.isEmpty()) {
            out.append("Items: None");
            return out.toString();
        }

        out.append("Items:\n");

        for (Item item : heroItems) {
            out.append(item.toString()).append("\n");
        }

        return out.substring(0, out.length() - 1);
    }
}
package hell.commands;

import hell.entities.items.CommonItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ItemCommand extends BaseCommand {

    public ItemCommand(String[] tokens, Map<String, Hero> heroes) {
        super(tokens, heroes);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = super.getTokens();

        String heroName = tokens[2];

        Item itemObject = new CommonItem(
                tokens[1],
                Integer.parseInt(tokens[3]),
                Integer.parseInt(tokens[4]),
                Integer.parseInt(tokens[5]),
                Integer.parseInt(tokens[6]),
                Integer.parseInt(tokens[7])
        );

        Hero heroObject = super.getHeroes().get(heroName);
        heroObject.addItem(itemObject);

        return String.format("Added item - %s to Hero - %s", tokens[1], tokens[2]);
    }
}
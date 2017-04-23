package hell.commands;

import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class RecipeCommand extends BaseCommand {

    public RecipeCommand(String[] tokens, Map<String, Hero> heroes) {
        super(tokens, heroes);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = super.getTokens();

        List<String> requiredItems = new ArrayList<>();

        requiredItems.addAll(Arrays.asList(tokens).subList(8, tokens.length));

        String[] requiredItemsAsArray = requiredItems.toArray(new String[requiredItems.size() - 1]);

        Recipe itemObject = new RecipeItem(
                tokens[1],
                Integer.parseInt(tokens[3]),
                Integer.parseInt(tokens[4]),
                Integer.parseInt(tokens[5]),
                Integer.parseInt(tokens[6]),
                Integer.parseInt(tokens[7]),
                requiredItemsAsArray
        );

        Hero heroObject = super.getHeroes().get(tokens[2]);
        heroObject.addRecipe(itemObject);

        return String.format("Added recipe - %s to Hero - %s", tokens[1], tokens[2]);
    }
}
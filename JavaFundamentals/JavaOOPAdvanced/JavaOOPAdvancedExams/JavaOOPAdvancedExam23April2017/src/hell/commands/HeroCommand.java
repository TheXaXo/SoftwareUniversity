package hell.commands;

import hell.interfaces.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class HeroCommand extends BaseCommand {

    private static final String HEROES_PATH = "hell.entities.heroes.";

    public HeroCommand(String[] tokens, Map<String, Hero> heroes) {
        super(tokens, heroes);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = super.getTokens();

        String heroName = tokens[1];
        String heroType = tokens[2];

        Class<? extends Hero> heroClass = (Class<? extends Hero>) Class.forName(HEROES_PATH + heroType);
        Constructor<? extends Hero> constructor = (Constructor<? extends Hero>) heroClass.getDeclaredConstructors()[0];

        Hero heroObject = constructor.newInstance(heroName);
        super.getHeroes().put(heroName, heroObject);

        return String.format("Created %s - %s", heroType, heroName);
    }
}
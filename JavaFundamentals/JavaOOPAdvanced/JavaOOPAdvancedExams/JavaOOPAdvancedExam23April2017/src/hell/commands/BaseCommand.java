package hell.commands;

import hell.interfaces.Hero;

import java.util.Map;

public abstract class BaseCommand implements Executable {

    private String[] tokens;
    private Map<String, Hero> heroes;

    protected BaseCommand(String[] tokens, Map<String, Hero> heroes) {
        this.tokens = tokens;
        this.heroes = heroes;
    }

    protected String[] getTokens() {
        return this.tokens;
    }

    protected Map<String, Hero> getHeroes() {
        return this.heroes;
    }
}
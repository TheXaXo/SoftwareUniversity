package PokemonTrainer;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private int badgesCount;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        pokemons = new ArrayList<Pokemon>();
    }

    public String getName() {
        return this.name;
    }

    public int getBadgesCount() {
        return this.badgesCount;
    }

    public void addbadge() {
        this.badgesCount++;
    }

    public ArrayList<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
}
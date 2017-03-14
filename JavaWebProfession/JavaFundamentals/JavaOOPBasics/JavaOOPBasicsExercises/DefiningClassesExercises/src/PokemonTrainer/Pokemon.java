package PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }

    public void decrementHealth() {
        this.health -= 10;

        if (this.health <= 0) {
            throw new IllegalStateException();
        }
    }
}

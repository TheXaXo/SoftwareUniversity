package rpg_lab;

import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;
    private Random rnd;

    public Dummy(int health, int experience, List<Weapon> possibleLoot) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = possibleLoot;
        this.rnd = new Random();
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon dropLoot() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.possibleLoot.get(this.rnd.nextInt(this.possibleLoot.size()));
    }
}
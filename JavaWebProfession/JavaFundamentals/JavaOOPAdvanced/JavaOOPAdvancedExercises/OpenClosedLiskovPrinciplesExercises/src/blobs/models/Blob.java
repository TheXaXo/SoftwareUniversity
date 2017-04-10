package blobs.models;

import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;

public class Blob {

    private String name;
    private int currentHealth;
    private int damage;

    private Behavior behavior;
    private Attack attack;

    private int initialHealth;
    private int initialDamage;

    public Blob(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;

        this.initialHealth = health;
        this.initialDamage = damage;
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.getIsTriggered()) {
            this.triggerBehavior();
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public void attack(Blob target) {
        if (this.getHealth() > 0) {
            this.attack.execute(this, target);
        }
    }

    public void respond(int damage) {
        this.setHealth(this.getHealth() - damage);
    }

    public void triggerBehavior() {
        if (!this.behavior.getIsTriggered()) {
            this.behavior.trigger(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void update() {
        if (this.behavior.getIsTriggered()) {
            this.behavior.applyRecurrentEffect(this);
        }
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.getName());
        }
        return String.format("Blob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }
}
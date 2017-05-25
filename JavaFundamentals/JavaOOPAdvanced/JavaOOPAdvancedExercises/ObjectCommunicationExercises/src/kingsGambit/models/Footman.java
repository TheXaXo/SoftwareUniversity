package kingsGambit.models;

public class Footman extends Person implements Observer {

    private static final int FOOTMAN_HEALTH = 2;

    private int health;

    public Footman(String name) {
        super(name);
        this.health = FOOTMAN_HEALTH;
    }

    @Override
    public void notifyCurrent() {
        System.out.printf("Footman %s is panicking!%n", super.getName());
    }

    @Override
    public void takeHit() {
        this.health = this.health - 1;
    }

    @Override
    public int getHealth() {
        return this.health;
    }
}
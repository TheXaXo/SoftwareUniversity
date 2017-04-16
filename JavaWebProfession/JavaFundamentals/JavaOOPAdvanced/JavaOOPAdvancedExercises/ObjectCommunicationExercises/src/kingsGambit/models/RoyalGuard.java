package kingsGambit.models;

public class RoyalGuard extends Person implements Observer {

    private static final int ROYAL_GUARD_HEALTH = 3;

    private int health;

    public RoyalGuard(String name) {
        super(name);
        this.health = ROYAL_GUARD_HEALTH;
    }

    @Override
    public void notifyCurrent() {
        System.out.printf("Royal Guard %s is defending!%n", super.getName());
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
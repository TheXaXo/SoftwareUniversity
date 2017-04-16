package models.attackers;

import logger.Handler;
import logger.LogType;
import models.targets.ObservableTarget;
import models.targets.Target;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "models.targets.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";
    private static final String EXPERIENCE_GAINED_MESSAGE = "%s gained %d xp";

    private String id;
    private int dmg;
    private ObservableTarget target;
    private Handler handler;

    public AbstractHero(String id, int dmg, Handler handler) {
        this.id = id;
        this.dmg = dmg;
        this.handler = handler;
    }

    public Handler getHandler() {
        return this.handler;
    }

    @Override
    public void setTarget(ObservableTarget target) {
        if (target == null) {
            this.handler.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            if (this.target != null) {
                this.target.unregister(this);
            }

            this.target = target;
            this.target.register(this);
            this.handler.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    @Override
    public final void attack() {
        if (this.target == null) {
            this.handler.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.handler.handle(LogType.ERROR, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg);

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void update(int reward) {
        if (this.handler != null) {
            this.handler.handle(LogType.EVENT, String.format(EXPERIENCE_GAINED_MESSAGE, this, reward));
        }
    }
}
package blobs.models.behaviours;

import blobs.models.Blob;

public class Inflated extends AbstractBehavior {

    private static final int HEALTH_GIVEN = 50;
    private static final int HEALTH_TAKEN_EACH_TURN = 10;

    public Inflated() {
        super();
        super.setToDelayRecurrentEffect(true);
    }

    @Override
    public void trigger(Blob source) {
        if (!super.getIsTriggered()) {
            super.setIsTriggered(true);
            source.setHealth(source.getHealth() + HEALTH_GIVEN);
        }
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.getToDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - HEALTH_TAKEN_EACH_TURN);
        }
    }
}
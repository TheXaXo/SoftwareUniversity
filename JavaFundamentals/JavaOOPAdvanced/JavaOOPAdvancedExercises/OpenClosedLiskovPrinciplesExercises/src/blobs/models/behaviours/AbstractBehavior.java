package blobs.models.behaviours;

import blobs.interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    public AbstractBehavior() {
        this.toDelayRecurrentEffect = true;
    }

    public boolean getIsTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    public boolean getToDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect) {
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }
}
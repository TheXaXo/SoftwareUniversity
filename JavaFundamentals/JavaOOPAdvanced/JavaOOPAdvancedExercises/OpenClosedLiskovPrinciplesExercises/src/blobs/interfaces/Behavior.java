package blobs.interfaces;

import blobs.models.Blob;

public interface Behavior {

    boolean getIsTriggered();

    void setIsTriggered(boolean value);

    boolean getToDelayRecurrentEffect();

    void setToDelayRecurrentEffect(boolean value);

    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);
}
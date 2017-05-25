package bg.softuni.contracts;

import bg.softuni.core.Tracker;

public interface Center {

    String getName();

    boolean getIsRetired();

    String getType();

    void processEmergency(Emergency emergency, Tracker tracker);
}

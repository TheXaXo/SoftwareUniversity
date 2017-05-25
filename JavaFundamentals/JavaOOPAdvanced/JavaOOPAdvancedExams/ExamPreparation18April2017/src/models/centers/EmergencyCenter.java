package models.centers;

import models.emergencies.Emergency;
import core.Tracker;

public interface EmergencyCenter {

    String getName();

    boolean getIsRetired();

    String getType();

    void processEmergency(Emergency emergency, Tracker tracker);
}

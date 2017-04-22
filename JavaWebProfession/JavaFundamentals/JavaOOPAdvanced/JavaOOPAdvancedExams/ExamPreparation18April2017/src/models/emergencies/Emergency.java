package models.emergencies;

import core.Tracker;
import enums.EmergencyLevel;
import utils.RegistrationTimeImpl;

public interface Emergency {

    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTimeImpl getRegistrationTime();

    String getType();

    void process(Tracker tracker);
}
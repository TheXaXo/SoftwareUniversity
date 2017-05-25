package bg.softuni.contracts;

import bg.softuni.core.Tracker;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public interface Emergency {

    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();

    String getType();

    void process(Tracker tracker);
}
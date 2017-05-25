package models.emergencies;

import core.Tracker;
import enums.EmergencyLevel;
import utils.RegistrationTimeImpl;

public class HealthEmergency extends BaseEmergency {

    private static final String EMERGENCY_TYPE = "Health";

    private int numberOfCasualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel,
                           RegistrationTimeImpl registrationTime, int numberOfCasualties) {
        super(description, emergencyLevel, registrationTime, EMERGENCY_TYPE);
        this.numberOfCasualties = numberOfCasualties;
    }

    @Override
    public void process(Tracker tracker) {
        tracker.saveCasualties(this.numberOfCasualties);
    }
}
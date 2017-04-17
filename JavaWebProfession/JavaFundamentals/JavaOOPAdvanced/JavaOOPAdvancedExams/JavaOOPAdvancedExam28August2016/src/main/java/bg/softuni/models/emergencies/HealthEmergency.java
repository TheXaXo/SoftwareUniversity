package bg.softuni.models.emergencies;

import bg.softuni.core.Tracker;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class HealthEmergency extends BaseEmergency {

    private static final String EMERGENCY_TYPE = "Health";

    private int numberOfCasualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel,
                           RegistrationTime registrationTime, int numberOfCasualties) {
        super(description, emergencyLevel, registrationTime, EMERGENCY_TYPE);
        this.numberOfCasualties = numberOfCasualties;
    }

    @Override
    public void process(Tracker tracker) {
        tracker.saveCasualties(this.numberOfCasualties);
    }
}
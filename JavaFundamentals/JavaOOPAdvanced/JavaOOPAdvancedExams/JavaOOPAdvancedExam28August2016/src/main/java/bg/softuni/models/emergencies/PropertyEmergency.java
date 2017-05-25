package bg.softuni.models.emergencies;

import bg.softuni.core.Tracker;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency {

    private static final String EMERGENCY_TYPE = "Property";

    private int damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel,
                             RegistrationTime registrationTime, int damage) {
        super(description, emergencyLevel, registrationTime, EMERGENCY_TYPE);
        this.damage = damage;
    }

    @Override
    public void process(Tracker tracker) {
        tracker.fixDamage(this.damage);
    }
}
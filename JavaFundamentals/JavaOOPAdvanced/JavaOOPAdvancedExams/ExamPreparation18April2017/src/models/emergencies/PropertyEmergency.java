package models.emergencies;

import core.Tracker;
import enums.EmergencyLevel;
import utils.RegistrationTimeImpl;

public class PropertyEmergency extends BaseEmergency {

    private static final String EMERGENCY_TYPE = "Property";

    private int damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel,
                             RegistrationTimeImpl registrationTime, int damage) {
        super(description, emergencyLevel, registrationTime, EMERGENCY_TYPE);
        this.damage = damage;
    }

    @Override
    public void process(Tracker tracker) {
        tracker.fixDamage(this.damage);
    }
}
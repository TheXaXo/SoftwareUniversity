package models.emergencies;

import core.Tracker;
import enums.EmergencyLevel;
import enums.Status;
import utils.RegistrationTimeImpl;

public class OrderEmergency extends BaseEmergency {

    private static final String EMERGENCY_TYPE = "Order";

    private Status status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel,
                          RegistrationTimeImpl registrationTime, Status status) {
        super(description, emergencyLevel, registrationTime, EMERGENCY_TYPE);
        this.status = status;
    }

    @Override
    public void process(Tracker tracker) {
        if (this.status.toString().equals("Special")) {
            tracker.processCase();
        }
    }
}
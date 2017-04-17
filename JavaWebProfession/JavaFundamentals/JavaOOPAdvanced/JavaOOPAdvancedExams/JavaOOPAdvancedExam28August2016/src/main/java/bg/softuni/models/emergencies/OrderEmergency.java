package bg.softuni.models.emergencies;

import bg.softuni.core.Tracker;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency {

    private static final String EMERGENCY_TYPE = "Order";

    private String status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel,
                          RegistrationTime registrationTime, String status) {
        super(description, emergencyLevel, registrationTime, EMERGENCY_TYPE);
        this.status = status;
    }

    @Override
    public void process(Tracker tracker) {
        if (this.status.equals("Special")) {
            tracker.processCase();
        }
    }
}
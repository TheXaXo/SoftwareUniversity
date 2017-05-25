package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTimeImpl;

public abstract class BaseEmergency implements Emergency {

    private String description;
    private EmergencyLevel emergencyLevel;
    private RegistrationTimeImpl registrationTime;
    private String type;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel,
                            RegistrationTimeImpl registrationTime, String type) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);
        this.type = type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }

    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    @Override
    public RegistrationTimeImpl getRegistrationTime() {
        return registrationTime;
    }

    private void setRegistrationTime(RegistrationTimeImpl registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
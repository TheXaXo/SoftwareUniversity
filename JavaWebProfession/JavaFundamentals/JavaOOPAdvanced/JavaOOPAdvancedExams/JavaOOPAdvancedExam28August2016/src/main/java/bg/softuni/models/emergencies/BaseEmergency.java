package bg.softuni.models.emergencies;

import bg.softuni.contracts.Emergency;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public abstract class BaseEmergency implements Emergency {

    private String description;
    private EmergencyLevel emergencyLevel;
    private RegistrationTime registrationTime;
    private String type;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel,
                            RegistrationTime registrationTime, String type) {
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
    public RegistrationTime getRegistrationTime() {
        return registrationTime;
    }

    private void setRegistrationTime(RegistrationTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
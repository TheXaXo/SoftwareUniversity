package models.centers;

import annotations.InjectType;

@InjectType(type = "Medical")
public class MedicalServiceCenter extends BaseEmergencyCenter {

    private static final String CENTER_TYPE = "Health";

    public MedicalServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies, CENTER_TYPE);
    }
}

package models.centers;

import annotations.InjectType;

@InjectType(type = "Fire")
public class FiremanServiceCenter extends BaseEmergencyCenter {

    private static final String CENTER_TYPE = "Property";

    public FiremanServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies, CENTER_TYPE);
    }
}
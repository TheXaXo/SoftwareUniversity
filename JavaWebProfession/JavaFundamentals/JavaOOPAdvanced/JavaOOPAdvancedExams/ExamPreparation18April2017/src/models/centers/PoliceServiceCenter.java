package models.centers;

import annotations.InjectType;

@InjectType(type = "Police")
public class PoliceServiceCenter extends BaseEmergencyCenter {

    private static final String CENTER_TYPE = "Order";

    public PoliceServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies, CENTER_TYPE);
    }
}
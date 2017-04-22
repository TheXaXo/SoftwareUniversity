package models.centers;

import models.emergencies.Emergency;
import core.Tracker;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEmergencyCenter implements EmergencyCenter {

    private String name;
    private Integer amountOfMaximumEmergencies;
    private List<Emergency> processedEmergencies;
    private boolean isRetired;
    private String type;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies, String type) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.processedEmergencies = new ArrayList<>();
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    @Override
    public boolean getIsRetired() {
        return this.isRetired;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void processEmergency(Emergency emergency, Tracker tracker) {
        this.processedEmergencies.add(emergency);
        emergency.process(tracker);

        if (this.processedEmergencies.size() >= this.amountOfMaximumEmergencies) {
            this.isRetired = true;
        }
    }
}
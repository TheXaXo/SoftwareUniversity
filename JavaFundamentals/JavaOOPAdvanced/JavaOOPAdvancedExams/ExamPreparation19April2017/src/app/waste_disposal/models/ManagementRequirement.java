package app.waste_disposal.models;

public class ManagementRequirement {

    private double minEnergyBalance;
    private double minCapital;
    private String bannedGarbageType;
    private boolean isActive;

    public double getMinEnergyBalance() {
        return this.minEnergyBalance;
    }

    public void setMinEnergyBalance(double minEnergyBalance) {
        this.minEnergyBalance = minEnergyBalance;
    }

    public double getMinCapital() {
        return this.minCapital;
    }

    public void setMinCapital(double minCapital) {
        this.minCapital = minCapital;
    }

    public String getBannedGarbageType() {
        return this.bannedGarbageType;
    }

    public void setBannedGarbageType(String bannedGarbageType) {
        this.bannedGarbageType = bannedGarbageType;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
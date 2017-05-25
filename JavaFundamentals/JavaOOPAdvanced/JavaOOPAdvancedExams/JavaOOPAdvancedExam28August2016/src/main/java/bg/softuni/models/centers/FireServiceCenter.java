package bg.softuni.models.centers;

public class FireServiceCenter extends BaseEmergencyCenter {

    private static final String CENTER_TYPE = "Property";

    public FireServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies, CENTER_TYPE);
    }
}
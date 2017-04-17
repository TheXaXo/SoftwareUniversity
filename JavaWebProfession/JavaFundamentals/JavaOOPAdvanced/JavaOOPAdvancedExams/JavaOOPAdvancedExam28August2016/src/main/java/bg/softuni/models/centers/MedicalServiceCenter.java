package bg.softuni.models.centers;

public class MedicalServiceCenter extends BaseEmergencyCenter {

    private static final String CENTER_TYPE = "Health";

    public MedicalServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies, CENTER_TYPE);
    }
}

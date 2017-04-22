package core;

import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

public interface ManagementSystem {

    String registerEmergency(Emergency emergency);

    String registerServiceCenter(EmergencyCenter serviceCenter);

    String processEmergencies(String type, Tracker tracker);

    String emergencyReport(Tracker tracker);
}
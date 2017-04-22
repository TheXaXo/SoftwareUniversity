package core;

import annotations.InjectType;
import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

import java.util.*;

public class EmergencyManagementSystem implements ManagementSystem {

    //I don't need no registers
    private Map<String, List<Emergency>> emergencies;
    private Map<String, Deque<EmergencyCenter>> centers;
    private int processedEmergencies;

    public EmergencyManagementSystem() {
        this.emergencies = new LinkedHashMap<>();
        this.centers = new LinkedHashMap<>();
    }

    @Override
    public String registerEmergency(Emergency emergency) {
        this.emergencies.putIfAbsent(emergency.getType(), new ArrayList<>());
        this.emergencies.get(emergency.getType()).add(emergency);

        String[] emergencyNameWords = emergency.getClass().getSimpleName()
                .split("(?=\\p{Upper})");

        return String.format("Registered Public %s %s of level %s at %s.",
                emergencyNameWords[0], emergencyNameWords[1],
                emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerServiceCenter(EmergencyCenter serviceCenter) {
        this.centers.putIfAbsent(serviceCenter.getType(), new ArrayDeque<>());
        this.centers.get(serviceCenter.getType()).add(serviceCenter);

        InjectType centerTypeAnnotation = serviceCenter.getClass().getDeclaredAnnotation(InjectType.class);
        String centerType = centerTypeAnnotation.type();

        return String.format("Registered %s Service Emergency Center - %s.",
                centerType, serviceCenter.getName());
    }

    @Override
    public String processEmergencies(String type, Tracker tracker) {
        this.emergencies.putIfAbsent(type, new ArrayList<>());

        for (int i = 0; i < this.emergencies.get(type).size(); i++) {
            Emergency emergencyToProcess = this.emergencies.get(type).get(i);

            if (this.centers.containsKey(emergencyToProcess.getType()) &&
                    !this.centers.get(emergencyToProcess.getType()).isEmpty()) {

                EmergencyCenter center = this.centers.get(emergencyToProcess.getType()).remove();
                center.processEmergency(emergencyToProcess, tracker);

                if (!center.getIsRetired()) {
                    this.centers.get(emergencyToProcess.getType()).add(center);
                }

                this.emergencies.get(type).remove(i);
                this.processedEmergencies++;
                i--;
            }
        }

        if (this.emergencies.get(type).isEmpty()) {
            return String.format("Successfully responded to all %s emergencies.", type);
        }

        return String.format("%s Emergencies left to process: %d.",
                type, this.emergencies.get(type).size());
    }

    @Override
    public String emergencyReport(Tracker tracker) {
        return String.format("PRRM Services Live Statistics\nFire Service Centers: %d\n" +
                        "Medical Service Centers: %d\nPolice Service Centers: %d\n" +
                        "Total Processed Emergencies: %d\nCurrently Registered Emergencies: %d\n" +
                        "Total Property Damage Fixed: %d\nTotal Health Casualties Saved: %d\n" +
                        "Total Special Cases Processed: %d",
                this.getCentersCount("Property"),
                this.getCentersCount("Health"),
                this.getCentersCount("Order"),
                this.processedEmergencies,
                this.emergencies.values().stream().mapToInt(List::size).sum(),
                tracker.getDamageFixed(),
                tracker.getCasualtiesSaved(),
                tracker.getSpecialCasesProcessed());
    }

    private int getCentersCount(String type) {
        if (!this.centers.containsKey(type)) {
            return 0;
        }

        return this.centers.get(type).size();
    }
}
package program;

import java.util.LinkedHashMap;

public class TheDump {

    private TheSystem theSystem;
    private LinkedHashMap<String, HardwareComponent> dumpedComponents;

    public TheDump(TheSystem theSystem) {
        this.theSystem = theSystem;
        this.dumpedComponents = new LinkedHashMap<>();
    }

    public void dump(String hardwareComponentName) {
        if (!theSystem.getComponents().containsKey(hardwareComponentName)) {
            return;
        }

        this.dumpedComponents.put(hardwareComponentName, theSystem.getComponents().get(hardwareComponentName));
        theSystem.removeComponent(hardwareComponentName);
    }

    public void restore(String hardwareComponentName) {
        if (!this.dumpedComponents.containsKey(hardwareComponentName)) {
            return;
        }

        HardwareComponent componentToRestore = this.dumpedComponents.get(hardwareComponentName);
        this.dumpedComponents.remove(hardwareComponentName);
        theSystem.addComponent(componentToRestore);
    }

    public void destroy(String hardwareComponentName) {
        if (!this.dumpedComponents.containsKey(hardwareComponentName)) {
            return;
        }

        this.dumpedComponents.remove(hardwareComponentName);
    }

    public String dumpAnalyze() {
        StringBuilder out = new StringBuilder();

        out.append("Dump Analysis\n");
        out.append(String.format("Power Hardware Components: %d%n", this.dumpedComponents.values().stream()
                .filter(a -> a.getType().equals("Power"))
                .count()));
        out.append(String.format("Heavy Hardware Components: %d%n", this.dumpedComponents.values().stream()
                .filter(a -> a.getType().equals("Heavy"))
                .count()));
        out.append(String.format("Express Software Components: %d%n", this.dumpedComponents.values().stream()
                .flatMap(a -> a.getSoftwareComponents().values().stream())
                .filter(a -> a.getType().equals("Express"))
                .count()));
        out.append(String.format("Light Software Components: %d%n", this.dumpedComponents.values().stream()
                .flatMap(a -> a.getSoftwareComponents().values().stream())
                .filter(a -> a.getType().equals("Light"))
                .count()));
        out.append(String.format("Total Dumped Memory: %d%n", this.dumpedComponents.values().stream()
                .flatMap(a -> a.getSoftwareComponents().values().stream())
                .mapToLong(SoftwareComponent::getMemory)
                .sum()));
        out.append(String.format("Total Dumped Capacity: %d%n", this.dumpedComponents.values().stream()
                .flatMap(a -> a.getSoftwareComponents().values().stream())
                .mapToLong(SoftwareComponent::getCapacity)
                .sum()));

        return out.toString();
    }
}
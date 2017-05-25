package program;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TheSystem {
    private LinkedHashMap<String, HardwareComponent> components;

    public TheSystem() {
        this.components = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        PowerHardwareComponent component = new PowerHardwareComponent(name, capacity, memory);

        components.put(name, component);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HeavyHardwareComponent component = new HeavyHardwareComponent(name, capacity, memory);

        components.put(name, component);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        ExpressSoftwareComponent software = new ExpressSoftwareComponent(name, capacity, memory);

        if (!components.containsKey(hardwareComponentName) ||
                components.get(hardwareComponentName).getFreeCapacity() < capacity ||
                components.get(hardwareComponentName).getFreeMemory() < memory) {
            return;
        }

        components.get(hardwareComponentName).addSoftware(software);
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        LightSoftwareComponent software = new LightSoftwareComponent(name, capacity, memory);

        if (!components.containsKey(hardwareComponentName) ||
                components.get(hardwareComponentName).getFreeCapacity() < capacity ||
                components.get(hardwareComponentName).getFreeMemory() < memory) {
            return;
        }

        components.get(hardwareComponentName).addSoftware(software);
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (!this.components.containsKey(hardwareComponentName) ||
                !this.components.get(hardwareComponentName).containsSoftware(softwareComponentName)) {
            return;
        }

        this.components.get(hardwareComponentName).removeSoftware(softwareComponentName);
    }

    public String analyze() {
        StringBuilder out = new StringBuilder();

        out.append("System Analysis\n");
        out.append(String.format("Hardware Components: %d%n", this.components.size()));
        out.append(String.format("Software Components: %d%n", this.components.values().stream()
                .mapToLong(a -> a.getSoftwareComponents()
                        .size())
                .sum()));
        out.append(String.format("Total Operational Memory: %d / %d%n", this.components.values().stream()
                .flatMap(a -> a.getSoftwareComponents()
                        .values().stream())
                .mapToLong(SoftwareComponent::getMemory)
                .sum(), this.components.values().stream().mapToLong(HardwareComponent::getMemory).sum()));
        out.append(String.format("Total Capacity Taken: %d / %d%n", this.components.values().stream()
                .flatMap(a -> a.getSoftwareComponents()
                        .values().stream())
                .mapToLong(SoftwareComponent::getCapacity)
                .sum(), this.components.values().stream().mapToLong(HardwareComponent::getCapacity).sum()));

        return out.toString();
    }

    public String split() {
        StringBuilder out = new StringBuilder();

        this.components.values().stream()
                .sorted((a, b) -> {
                    if (a.getType().equals("Power") && !b.getType().equals("Power")) {
                        return -1;
                    } else if (b.getType().equals("Power") && !a.getType().equals("Power")) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .forEach(component -> out.append(this.getComponentInfo(component)));

        return out.toString();
    }

    public String getComponentInfo(HardwareComponent component) {
        StringBuilder componentInfo = new StringBuilder();

        componentInfo.append(String.format("Hardware Component - %s%n", component.getName()));
        componentInfo.append(String.format("Express Software Components - %d%n", component.getSoftwareComponents().values().stream()
                .filter(c -> c.getType().equals("Express"))
                .count()));
        componentInfo.append(String.format("Light Software Components - %d%n", component.getSoftwareComponents().values().stream()
                .filter(c -> c.getType().equals("Light"))
                .count()));
        componentInfo.append(String.format("Memory Usage: %d / %d%n", component.getSoftwareComponents().values().stream()
                .mapToLong(SoftwareComponent::getMemory)
                .sum(), component.getMemory()));
        componentInfo.append(String.format("Capacity Usage: %d / %d%n", component.getSoftwareComponents().values().stream()
                .mapToLong(SoftwareComponent::getCapacity)
                .sum(), component.getCapacity()));
        componentInfo.append(String.format("Type: %s%n", component.getType()));
        componentInfo.append(String.format("Software Components: %s%n", component.getAllSoftwareNames()));

        return componentInfo.toString();
    }

    public Map<String, HardwareComponent> getComponents() {
        return Collections.unmodifiableMap(this.components);
    }

    public void removeComponent(String componentName) {
        this.components.remove(componentName);
    }

    public void addComponent(HardwareComponent component) {
        this.components.put(component.getName(), component);
    }
}
package program;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class HardwareComponent extends Component {

    private LinkedHashMap<String, SoftwareComponent> softwareComponents;
    private int maximumCapacity;
    private int maximumMemory;

    public HardwareComponent(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type);
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.softwareComponents = new LinkedHashMap<>();
    }

    @Override
    public int getMemory() {
        return this.maximumMemory;
    }

    @Override
    public int getCapacity() {
        return this.maximumCapacity;
    }

    public int getFreeCapacity() {
        return this.maximumCapacity - this.softwareComponents.values().stream().mapToInt(SoftwareComponent::getCapacity).sum();
    }

    public int getFreeMemory() {
        return this.maximumMemory - this.softwareComponents.values().stream().mapToInt(SoftwareComponent::getMemory).sum();
    }

    public void addSoftware(SoftwareComponent softwareComponent) {
        this.softwareComponents.put(softwareComponent.getName(), softwareComponent);
    }

    public void removeSoftware(String softwareName) {
        this.softwareComponents.remove(softwareName);
    }

    public boolean containsSoftware(String softwareName) {
        return this.softwareComponents.containsKey(softwareName);
    }

    public Map<String, SoftwareComponent> getSoftwareComponents() {
        return Collections.unmodifiableMap(this.softwareComponents);
    }

    public String getAllSoftwareNames() {
        if (this.getSoftwareComponents().isEmpty()) {
            return "None";
        }

        return String.join(", ", softwareComponents.values().stream().map(Component::getName).collect(Collectors.toList()));
    }
}
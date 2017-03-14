package program;

public class HeavyHardwareComponent extends HardwareComponent {

    public HeavyHardwareComponent(String name, int maximumCapacity, int maximumMemory) {
        super(name, "Heavy", maximumCapacity * 2, (int) (maximumMemory * 0.75));
    }
}
package program;

public class PowerHardwareComponent extends HardwareComponent {

    public PowerHardwareComponent(String name, int maximumCapacity, int maximumMemory) {
        super(name, "Power", (int) (maximumCapacity * 0.25), (int) (maximumMemory * 1.75));
    }
}
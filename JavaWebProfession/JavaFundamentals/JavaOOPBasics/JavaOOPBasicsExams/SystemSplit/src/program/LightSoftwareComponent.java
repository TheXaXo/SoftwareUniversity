package program;

public class LightSoftwareComponent extends SoftwareComponent {

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, "Light", (int) (capacity * 1.5), (int) (memory * 0.5));
    }
}
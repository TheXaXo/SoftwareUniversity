package program;

public class ExpressSoftwareComponent extends SoftwareComponent {

    public ExpressSoftwareComponent(String name, int capacity, int memory) {
        super(name, "Express", capacity, memory * 2);
    }
}
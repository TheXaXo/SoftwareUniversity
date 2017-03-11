package program;

public abstract class SoftwareComponent extends Component {

    private int capacity;
    private int memory;

    public SoftwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.capacity = capacity;
        this.memory = memory;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
}

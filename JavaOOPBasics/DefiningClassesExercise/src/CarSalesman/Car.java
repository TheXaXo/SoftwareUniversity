package CarSalesman;

public class Car {
    private String name;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String name) {
        this.name = name;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public String getName() {
        return this.name;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append(this.name + ":").append("\r\n");
        out.append("  " + this.engine.getModel() + ":").append("\r\n");
        out.append("    Power: " + this.engine.getPower()).append("\r\n");
        out.append("    Displacement: " + this.engine.getDisplacement()).append("\r\n");
        out.append("    Efficiency: " + this.engine.getEfficiency()).append("\r\n");
        out.append("  Weight: " + this.getWeight()).append("\r\n");
        out.append("  Color: " + this.getColor());

        return out.toString();
    }
}
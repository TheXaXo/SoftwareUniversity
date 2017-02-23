package CatLady;

public class SiameseCat extends Cat {
    private double earSize;

    public SiameseCat(String name, double earSize) {
        this.setName(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return "Siamese " + this.getName() + " " + String.format("%.0f", this.earSize);
    }
}

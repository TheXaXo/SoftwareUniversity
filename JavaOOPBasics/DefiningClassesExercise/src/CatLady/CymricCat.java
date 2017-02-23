package CatLady;

public class CymricCat extends Cat {
    private double furLength;

    public CymricCat(String name, double furLength) {
        this.setName(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return "Cymric " + this.getName() + " " + String.format("%.2f", this.furLength);
    }
}

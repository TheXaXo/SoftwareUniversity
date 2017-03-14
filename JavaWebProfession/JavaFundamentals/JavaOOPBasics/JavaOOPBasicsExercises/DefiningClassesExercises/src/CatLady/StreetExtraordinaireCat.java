package CatLady;

public class StreetExtraordinaireCat extends Cat {
    private int decibelsOfMeow;

    public StreetExtraordinaireCat(String name, int decibelsOfMeow) {
        this.setName(name);
        this.decibelsOfMeow = decibelsOfMeow;
    }

    @Override
    public String toString() {
        return "StreetExtraordinaire " + this.getName() + " " + this.decibelsOfMeow;
    }
}
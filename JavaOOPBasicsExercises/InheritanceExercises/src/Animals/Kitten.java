package Animals;

public class Kitten extends Animal {
    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }
}
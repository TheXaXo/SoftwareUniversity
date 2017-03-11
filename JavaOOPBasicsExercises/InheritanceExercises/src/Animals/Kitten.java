package Animals;

public class Kitten extends Animal {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
        super.setSound("Miau");
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.equals("Female")) {
            throw new IllegalArgumentException("Invalid input!");
        }

        super.setGender(gender);
    }
}
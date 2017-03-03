package Animals;

public class Tomcat extends Animal {
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
        super.setSound("Give me one million b***h");
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.equals("Male")) {
            throw new IllegalArgumentException("Invalid input!");
        }

        super.setGender(gender);
    }
}
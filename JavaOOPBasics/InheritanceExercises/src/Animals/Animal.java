package Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;
    private String sound;

    public Animal() {

    }

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setSound("Not implemented!");
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    private String getGender() {
        return this.gender;
    }

    protected void setGender(String gender) {
        if (gender == null || gender.equals("")) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    protected String getSound() {
        return this.sound;
    }

    protected void setSound(String sound) {
        this.sound = sound;
    }

    public void produceSound() {
        System.out.println(this.getSound());
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s",
                this.getClass().getSimpleName(), this.getName(), this.getAge(), this.getGender());
    }
}
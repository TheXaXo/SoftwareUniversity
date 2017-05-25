package BirthdayCelebrations;

public class Citizen implements Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthdate(birthdate);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    private void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}

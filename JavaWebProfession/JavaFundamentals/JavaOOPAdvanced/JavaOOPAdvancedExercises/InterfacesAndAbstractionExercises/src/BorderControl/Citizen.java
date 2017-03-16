package BorderControl;

public class Citizen implements Identifiable {

    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
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
}

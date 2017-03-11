public abstract class Animal {

    private String name;
    private int age;
    private boolean cleansingStatus;

    protected Animal(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public final String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public final int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public final boolean isCleansingStatus() {
        return this.cleansingStatus;
    }

    public void setCleansingStatus(boolean cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }
}

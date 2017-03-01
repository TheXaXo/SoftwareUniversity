public class Test10 extends TestProgram9 {
    private int age;

    public Test10(String name, int age) {
        super(name);
        this.setAge(age);
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

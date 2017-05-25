package StrategyPattern;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
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
    public String toString() {
        return this.getName() + " " + this.getAge();
    }
}
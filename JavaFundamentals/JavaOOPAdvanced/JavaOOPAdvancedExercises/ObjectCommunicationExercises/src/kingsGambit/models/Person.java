package kingsGambit.models;

public abstract class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
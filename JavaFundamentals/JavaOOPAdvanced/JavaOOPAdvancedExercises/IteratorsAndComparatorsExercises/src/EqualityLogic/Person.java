package EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {

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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person person = (Person) obj;

        return person.getName().equals(this.getName()) && this.getAge() == person.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }

    @Override
    public int compareTo(Person o) {
        PersonComparator comparator = new PersonComparator();

        return comparator.compare(this, o);
    }
}
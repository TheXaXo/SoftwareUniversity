package peopleDatabase;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PeopleDatabase {

    private Set<Person> people;

    public PeopleDatabase() {
        this.people = new HashSet<>();
    }

    public void add(Person person) {
        if (person.getId() < 0) {
            throw new UnsupportedOperationException("Id should not be negative!");
        }

        if (people.stream().anyMatch(a -> a.getId() == person.getId())) {
            throw new UnsupportedOperationException("There can't be multiple people with the same id!");
        }

        this.people.add(person);
    }

    public void remove(Person person) {
        this.people.remove(person);
    }

    public Person findByUserName(String userName) {
        if (userName == null) {
            throw new UnsupportedOperationException("User name should not be null!");
        }

        if (people.stream().noneMatch(a -> a.getUserName().equals(userName))) {
            throw new UnsupportedOperationException("There are no people with this username!");
        }

        return this.people.stream().filter(a -> a.getUserName().equals(userName)).findFirst().orElse(null);
    }

    public Person findById(int id) {
        Person personToReturn = this.people.stream().filter(a -> a.getId() == id).findFirst().orElse(null);

        if (personToReturn == null) {
            throw new UnsupportedOperationException("There are no people with this id!");
        }

        return personToReturn;
    }

    public Set<Person> getPeople() {
        return Collections.unmodifiableSet(this.people);
    }
}
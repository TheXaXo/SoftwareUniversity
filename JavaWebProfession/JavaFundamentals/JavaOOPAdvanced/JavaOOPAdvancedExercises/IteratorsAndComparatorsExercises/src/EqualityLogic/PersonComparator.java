package EqualityLogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName()) != 0 ? o1.getName().compareTo(o2.getName())
                : o1.getAge() > o2.getAge() ? 1 : o1.getAge() < o2.getAge() ? -1 : 0;
    }
}
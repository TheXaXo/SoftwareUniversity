import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import peopleDatabase.PeopleDatabase;
import peopleDatabase.Person;

public class PersonDatabaseTests {

    private PeopleDatabase database;
    private Person mockedPerson;

    @Before
    public void initializeDatabase() {
        this.database = new PeopleDatabase();
        this.mockedPerson = Mockito.mock(Person.class);
    }

    @Test
    public void makeNewPersonDatabase() {
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addPersonWithWrongId() {
        Mockito.when(this.mockedPerson.getId()).thenReturn(-1);

        database.add(mockedPerson);
    }

    @Test
    public void addPersonWithValidId() {
        Mockito.when(this.mockedPerson.getId()).thenReturn(1);

        database.add(mockedPerson);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addPersonWithSameId() {
        Mockito.when(this.mockedPerson.getId()).thenReturn(1);

        database.add(mockedPerson);
        database.add(mockedPerson);
    }

    @Test
    public void findPersonByExistingUserName() {
        Mockito.when(this.mockedPerson.getUserName()).thenReturn("Pesho");

        database.add(mockedPerson);
        database.findByUserName("Pesho");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void findPersonByNonExistingUserName() {
        Mockito.when(this.mockedPerson.getUserName()).thenReturn("Pesho");

        database.add(mockedPerson);
        database.findByUserName("Gosho");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void findPersonByNullUserName() {
        database.findByUserName(null);
    }

    @Test
    public void findPersonByExistingId() {
        Mockito.when(this.mockedPerson.getId()).thenReturn(1);

        database.add(mockedPerson);
        database.findById(this.mockedPerson.getId());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void findPersonByNonExistingId() {
        Mockito.when(this.mockedPerson.getId()).thenReturn(1);

        database.add(mockedPerson);
        database.findById(2);
    }
}
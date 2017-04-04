import database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTests {

    private static final Integer[] ITEMS_INVALID = new Integer[]{};
    private static final Integer[] ITEMS_VALID = new Integer[]{1, 2, 3};

    private static final int EXPECTED_LENGTH = ITEMS_VALID.length + 1;

    private Database<Integer> database;

    @Before
    public void initializeDatabase() {
        this.database = new Database<>(ITEMS_VALID);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void arrayInitializationWithInvalidArguments() {
        Database<Integer> database = new Database<>(ITEMS_INVALID);
    }

    @Test
    public void arrayInitializationWithValidArguments() {
    }

    @Test
    public void arrayAddElement() {
        database.addItem(1);

        Assert.assertEquals(EXPECTED_LENGTH, database.fetch().length);
    }

    @Test
    public void removeItemFromDatabase() {
        database.remove();

        Assert.assertEquals(ITEMS_VALID.length - 1, database.fetch().length);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeItemFromEmptyDatabase() {
        while (true) {
            database.remove();
        }
    }
}
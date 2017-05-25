import customLinkedList.CustomLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTests {
    private static final String TEST_VALUE = "Gosho";
    private static final String TEST_VALUE_2 = "Ivan";
    private static final int EXPECTED_INDEX = 1;

    private CustomLinkedList<String> list;

    @Before
    public void initializeList() {
        this.list = new CustomLinkedList<>();
    }

    @Test
    public void testAdding() {
        this.list.add(TEST_VALUE);

        Assert.assertEquals(TEST_VALUE, list.get(0));
    }

    @Test
    public void testContains() {
        this.list.add(TEST_VALUE);

        Assert.assertTrue(this.list.contains(TEST_VALUE));
    }

    @Test
    public void testIndexOf() {
        this.list.add(TEST_VALUE);
        this.list.add(TEST_VALUE_2);

        Assert.assertEquals(EXPECTED_INDEX, this.list.indexOf(TEST_VALUE_2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtInvalidIndex() {
        this.list.removeAt(-1);
    }

    @Test
    public void testSetting() {
        this.list.add(TEST_VALUE);
        this.list.set(0, TEST_VALUE_2);

        Assert.assertEquals(TEST_VALUE_2, this.list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetOnInvalidIndex() {
        this.list.get(100);
    }
}
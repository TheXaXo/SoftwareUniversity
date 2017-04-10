package P01_ExtendedArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListTests {

    private static final Integer EXPECTED_MAX_ELEMENT = 3;
    private static final Integer EXPECTED_MIN_ELEMENT = 1;

    private ExtendedArrayList<Integer> list;

    @Before
    public void initializeList() {
        this.list = new ExtendedArrayList<>();

        this.list.add(3);
        this.list.add(1);
    }

    @Test
    public void testMaxElement() {
        Assert.assertEquals(EXPECTED_MAX_ELEMENT, this.list.max());
    }

    @Test
    public void testMinElement() {
        Assert.assertEquals(EXPECTED_MIN_ELEMENT, this.list.min());
    }
}
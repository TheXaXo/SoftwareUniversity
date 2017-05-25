import iteratorTests.ListIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {

    private ListIterator<String> listIterator;

    @Before
    public void initializeListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>("Pesho", "Gosho");
    }

    @Test
    public void makeListIteratorWithValidArguments() throws OperationNotSupportedException {
    }

    @Test(expected = OperationNotSupportedException.class)
    public void makeListIteratorWithNullArgument() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>("Pesho", null);
    }

    @Test
    public void testPrinting() throws OperationNotSupportedException {
        this.listIterator.move();

        Assert.assertEquals("Gosho", this.listIterator.print());
    }

    @Test
    public void testHasNextCommand() {
        this.listIterator.move();

        Assert.assertEquals(false, this.listIterator.hasNext());
    }
}

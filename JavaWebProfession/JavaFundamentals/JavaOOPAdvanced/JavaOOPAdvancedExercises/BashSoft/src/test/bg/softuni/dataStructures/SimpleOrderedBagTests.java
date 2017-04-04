package test.bg.softuni.dataStructures;

import main.bg.softuni.dataStructures.SimpleOrderedBag;
import main.bg.softuni.dataStructures.SimpleSortedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleOrderedBagTests {

    private static final int EXPECTED_INITIAL_CAPACITY = 16;
    private static final int EXPECTED_INITIAL_NAMES_SIZE = 0;
    private static final int INITIAL_CAPACITY = 20;
    private static final int EXPECTED_NAMES_SIZE_AFTER_ADDING = 1;
    private static final String[] UNSORTED_ELEMENTS = new String[]{"Georgi", "Balkan", "Rosen"};
    private static final int EXPECTED_SIZE = 17;
    private static final int EXPECTED_SIZE_AFTER_ADD_ALL = 2;
    private static final String EXPECTED_OUTPUT = "Balkan, Georgi, Rosen";

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp() {
        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyConstructor() {
        Assert.assertEquals(EXPECTED_INITIAL_CAPACITY, this.names.capacity());
        Assert.assertEquals(EXPECTED_INITIAL_NAMES_SIZE, this.names.size());
    }

    @Test
    public void testConstructorWithInitialCapacity() {
        this.names = new SimpleSortedList<>(String.class, INITIAL_CAPACITY);

        Assert.assertEquals(INITIAL_CAPACITY, this.names.capacity());
    }

    @Test
    public void testConstructorWithInitialComparer() {
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER);

        Assert.assertEquals(EXPECTED_INITIAL_CAPACITY, this.names.capacity());
        Assert.assertEquals(EXPECTED_INITIAL_NAMES_SIZE, this.names.size());
    }

    @Test
    public void testConstructorWithAllParams() {
        this.names = new SimpleSortedList<>(String.class,
                String.CASE_INSENSITIVE_ORDER,
                INITIAL_CAPACITY);

        Assert.assertEquals(INITIAL_CAPACITY, this.names.capacity());
        Assert.assertEquals(EXPECTED_INITIAL_NAMES_SIZE, this.names.size());
    }

    @Test
    public void testAddIncreaseSize() {
        this.names.add("Pesho");

        Assert.assertEquals(EXPECTED_NAMES_SIZE_AFTER_ADDING, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullElement() {
        this.names.add(null);
    }

    @Test
    public void testIfUnsortedDataIsBeingHeldSorted() {
        boolean areSortedCorrectly = true;

        List<String> expectedSort = new ArrayList();
        Collections.addAll(expectedSort, UNSORTED_ELEMENTS);
        Collections.sort(expectedSort);

        for (String element : UNSORTED_ELEMENTS) {
            this.names.add(element);
        }

        int index = 0;

        for (String name : this.names) {
            if (!name.equals(expectedSort.get(index++))) {
                areSortedCorrectly = false;
                break;
            }
        }

        Assert.assertTrue(areSortedCorrectly);
    }

    @Test
    public void testAddingMoreThanInitialCapacity() {
        for (int i = 0; i < EXPECTED_INITIAL_CAPACITY + 1; i++) {
            this.names.add("Gosho");
        }

        Assert.assertEquals(EXPECTED_SIZE, this.names.size());
        Assert.assertTrue(this.names.capacity() != 16);
    }

    @Test
    public void testAddAll() {
        List<String> itemsToAdd = new ArrayList<>();
        itemsToAdd.add("Pesho");
        itemsToAdd.add("Gosho");

        this.names.addAll(itemsToAdd);

        Assert.assertEquals(EXPECTED_SIZE_AFTER_ADD_ALL, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllWithNullValue() {
        this.names.addAll(null);
    }

    @Test
    public void testRemoveValidElementDecreasesSize() {
        for (String element : UNSORTED_ELEMENTS) {
            this.names.add(element);
        }

        this.names.remove(UNSORTED_ELEMENTS[0]);

        Assert.assertEquals(2, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullElement() {
        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull() {
        for (String element : UNSORTED_ELEMENTS) {
            this.names.add(element);
        }

        this.names.joinWith(null);
    }

    @Test
    public void testJoinWorksFine() {
        for (String element : UNSORTED_ELEMENTS) {
            this.names.add(element);
        }

        String output = this.names.joinWith(", ");

        Assert.assertEquals(EXPECTED_OUTPUT, output);
    }
}
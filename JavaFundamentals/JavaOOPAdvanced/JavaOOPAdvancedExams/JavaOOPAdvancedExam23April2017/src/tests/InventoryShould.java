package tests;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InventoryShould {

    private static final int EXPECTED_ITEMS_COUNT = 1;

    private static final int MOCKED_ITEM_STRENGTH_BONUS = 10;
    private static final int MOCKED_ITEM_AGILITY_BONUS = 20;
    private static final int MOCKED_ITEM_INTELLIGENCE_BONUS = 30;
    private static final int MOCKED_ITEM_HIT_POINTS_BONUS = 40;
    private static final int MOCKED_ITEM_DAMAGE_BONUS = 50;

    private static final int MOCKED_RECIPE_STRENGTH_BONUS = 1;
    private static final int MOCKED_RECIPE_AGILITY_BONUS = 2;
    private static final int MOCKED_RECIPE_INTELLIGENCE_BONUS = 3;
    private static final int MOCKED_RECIPE_HIT_POINTS_BONUS = 4;
    private static final int MOCKED_RECIPE_DAMAGE_BONUS = 5;

    private static final String RECIPE_NAME = "Pesho";
    private static final String ITEM_NAME = "Ivo";

    private static final String FAKE_ITEM_NAME_ONE = "Gosho";
    private static final String FAKE_ITEM_NAME_TWO = "Ivan";

    private Inventory inventory;
    private Item mockedItem;
    private Recipe mockedRecipe;
    private List<String> fakeRequiredItemsList;

    private Item mockedItemContainedInListOne;
    private Item mockedItemContainedInListTwo;

    @Before
    public void initializeInventory() {
        this.inventory = new HeroInventory();
        this.mockedItem = Mockito.mock(Item.class);
        this.mockedRecipe = Mockito.mock(Recipe.class);
        this.fakeRequiredItemsList = new ArrayList<>(Arrays.asList(FAKE_ITEM_NAME_ONE, FAKE_ITEM_NAME_TWO));
        this.mockedItemContainedInListOne = Mockito.mock(Item.class);
        this.mockedItemContainedInListTwo = Mockito.mock(Item.class);

        Mockito.when(this.mockedItem.getStrengthBonus()).thenReturn(MOCKED_ITEM_STRENGTH_BONUS);
        Mockito.when(this.mockedItem.getAgilityBonus()).thenReturn(MOCKED_ITEM_AGILITY_BONUS);
        Mockito.when(this.mockedItem.getIntelligenceBonus()).thenReturn(MOCKED_ITEM_INTELLIGENCE_BONUS);
        Mockito.when(this.mockedItem.getHitPointsBonus()).thenReturn(MOCKED_ITEM_HIT_POINTS_BONUS);
        Mockito.when(this.mockedItem.getDamageBonus()).thenReturn(MOCKED_ITEM_DAMAGE_BONUS);

        Mockito.when(this.mockedRecipe.getName()).thenReturn(RECIPE_NAME);
        Mockito.when(this.mockedItem.getName()).thenReturn(ITEM_NAME);
        Mockito.when(this.mockedRecipe.getRequiredItems()).thenReturn(this.fakeRequiredItemsList);

        Mockito.when(this.mockedItemContainedInListOne.getName()).thenReturn(FAKE_ITEM_NAME_ONE);
        Mockito.when(this.mockedItemContainedInListTwo.getName()).thenReturn(FAKE_ITEM_NAME_TWO);

        Mockito.when(this.mockedRecipe.getStrengthBonus()).thenReturn(MOCKED_RECIPE_STRENGTH_BONUS);
        Mockito.when(this.mockedRecipe.getAgilityBonus()).thenReturn(MOCKED_RECIPE_AGILITY_BONUS);
        Mockito.when(this.mockedRecipe.getIntelligenceBonus()).thenReturn(MOCKED_RECIPE_INTELLIGENCE_BONUS);
        Mockito.when(this.mockedRecipe.getHitPointsBonus()).thenReturn(MOCKED_RECIPE_HIT_POINTS_BONUS);
        Mockito.when(this.mockedRecipe.getDamageBonus()).thenReturn(MOCKED_RECIPE_DAMAGE_BONUS);
    }

    @Test
    public void initializeCorrectly() {
        this.inventory = new HeroInventory();
    }

    @Test
    public void addItemWithoutException() {
        this.inventory.addCommonItem(this.mockedItem);
    }

    @Test
    public void addRecipeWithoutException() {
        this.inventory.addRecipeItem(this.mockedRecipe);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addItemToInnerMap() throws IllegalAccessException {
        this.inventory.addCommonItem(this.mockedItem);

        List<Item> items = this.getAllItems();

        Assert.assertEquals("The item provided was not added successfully!",
                EXPECTED_ITEMS_COUNT, items.size());
    }

    @Test
    public void returnCorrectTotalStrengthBonus() {
        this.inventory.addCommonItem(this.mockedItem);

        Assert.assertEquals("The strength bonus returned is wrong!",
                MOCKED_ITEM_STRENGTH_BONUS, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void returnCorrectTotalAgilityBonus() {
        this.inventory.addCommonItem(this.mockedItem);

        Assert.assertEquals("The agility bonus returned is wrong!",
                MOCKED_ITEM_AGILITY_BONUS, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void returnCorrectTotalIntelligenceBonus() {
        this.inventory.addCommonItem(this.mockedItem);

        Assert.assertEquals("The intelligence bonus returned is wrong!",
                MOCKED_ITEM_INTELLIGENCE_BONUS, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void returnCorrectTotalHitPointsBonus() {
        this.inventory.addCommonItem(this.mockedItem);

        Assert.assertEquals("The hit points bonus returned is wrong!",
                MOCKED_ITEM_HIT_POINTS_BONUS, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void returnCorrectTotalDamageBonus() {
        this.inventory.addCommonItem(this.mockedItem);

        Assert.assertEquals("The damage bonus returned is wrong!",
                MOCKED_ITEM_DAMAGE_BONUS, this.inventory.getTotalDamageBonus());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void createNewItemFromRecipe() throws IllegalAccessException {
        this.inventory.addRecipeItem(this.mockedRecipe);

        this.inventory.addCommonItem(this.mockedItemContainedInListOne);
        this.inventory.addCommonItem(this.mockedItemContainedInListTwo);

        List<Item> items = this.getAllItems();

        Item itemAddedToListAfterRecipeHasBeenFound = items.get(0);

        Assert.assertTrue("A common item was not created from the completed recipe!",
                itemAddedToListAfterRecipeHasBeenFound.getStrengthBonus() == MOCKED_RECIPE_STRENGTH_BONUS &&
                        itemAddedToListAfterRecipeHasBeenFound.getAgilityBonus() == MOCKED_RECIPE_AGILITY_BONUS &&
                        itemAddedToListAfterRecipeHasBeenFound.getIntelligenceBonus() == MOCKED_RECIPE_INTELLIGENCE_BONUS &&
                        itemAddedToListAfterRecipeHasBeenFound.getHitPointsBonus() == MOCKED_RECIPE_HIT_POINTS_BONUS &&
                        itemAddedToListAfterRecipeHasBeenFound.getDamageBonus() == MOCKED_RECIPE_DAMAGE_BONUS
        );
    }

    @Test
    public void removeCommonItemsNeededForRecipe() throws IllegalAccessException {
        this.inventory.addRecipeItem(this.mockedRecipe);

        this.inventory.addCommonItem(this.mockedItemContainedInListOne);
        this.inventory.addCommonItem(this.mockedItemContainedInListTwo);

        List<Item> items = this.getAllItems();

        Assert.assertTrue("Common items from recipe were not removed!",
                !items.contains(this.mockedItemContainedInListOne) &&
                        !items.contains(this.mockedItemContainedInListTwo));
    }

    @SuppressWarnings("unchecked")
    private List<Item> getAllItems() throws IllegalAccessException {
        Field[] inventoryFields = this.inventory.getClass().getDeclaredFields();

        List<Item> items = null;

        for (Field field : inventoryFields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);

                items = new ArrayList<>(((Map<String, Item>) field.get(this.inventory)).values());
            }
        }

        return items;
    }
}
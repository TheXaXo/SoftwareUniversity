package hell.entities.miscellaneous;

import hell.entities.items.CommonItem;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;
import java.util.stream.Collectors;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<>();
        this.recipeItems = new LinkedHashMap<>();
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getStrengthBonus).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getAgilityBonus).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getIntelligenceBonus).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getHitPointsBonus).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getDamageBonus).sum();
    }

    @Override
    public void addCommonItem(Item item) {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) {
        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    private void checkRecipes() {
        for (int i = 0; i < this.recipeItems.values().size(); i++) {
            Recipe recipe = new ArrayList<>(this.recipeItems.values()).get(i);

            if (!this.hasAllItems(recipe, this.commonItems.values())) {
                continue;
            }

            this.combineRecipe(recipe);
            i--;
        }
    }

    private boolean hasAllItems(Recipe recipe, Collection<Item> items) {
        List<String> requiredItems = new ArrayList<>(recipe.getRequiredItems());
        List<String> givenItems = items.stream()
                .map(Item::getName)
                .collect(Collectors.toCollection(ArrayList::new));

        return givenItems.containsAll(requiredItems);
    }

    private void combineRecipe(Recipe recipe) {
        List<String> requiredItems = recipe.getRequiredItems();

        for (String item : requiredItems) {
            this.commonItems.remove(item);
        }

        Item newItem = new CommonItem(recipe.getName(), recipe.getStrengthBonus(), recipe.getAgilityBonus(),
                recipe.getIntelligenceBonus(), recipe.getHitPointsBonus(), recipe.getDamageBonus());

        this.commonItems.put(newItem.getName(), newItem);
        this.recipeItems.remove(recipe.getName());
    }
}
package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;

    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;

        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() {
        Field[] inventoryFields = HeroInventory.class.getDeclaredFields();

        Collection<Item> items = null;

        for (Field field : inventoryFields) {
            if (!field.isAnnotationPresent(ItemCollection.class)) {
                continue;
            }

            field.setAccessible(true);

            try {
                items = ((Map<String, Item>) field.get(this.inventory)).values();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return items;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("%s: %s\n" +
                        "###HitPoints: %d\n" +
                        "###Damage: %d\n" +
                        "###Strength: %d\n" +
                        "###Agility: %d\n" +
                        "###Intelligence: %d\n",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getHitPoints(),
                this.getDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getIntelligence()));

        if (this.getItems().isEmpty()) {
            out.append("###Items: None");
            return out.toString();
        }

        out.append("###Items: ");

        StringBuilder itemsSb = new StringBuilder();

        for (Item item : this.getItems()) {
            itemsSb.append(item.getName()).append(", ");
        }

        out.append(itemsSb.substring(0, itemsSb.length() - 2));

        return out.toString();
    }
}
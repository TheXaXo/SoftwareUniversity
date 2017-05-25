package infernoInfinity;

import java.util.Arrays;
import java.util.Objects;

@CustomAnnotation(
        author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon> {

    private String name;
    private WeaponType type;
    private GemType[] gems;

    public Weapon(String name, String type) {
        this.setName(name);
        this.setType(type);
        this.gems = new GemType[this.getType().getSockets()];
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private WeaponType getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = WeaponType.valueOf(type);
    }

    private void setGems(GemType[] gems) {
        this.gems = gems;
    }

    private int calculateStrength() {
        return Arrays.stream(this.gems).filter(Objects::nonNull).mapToInt(GemType::getStrength).sum();
    }

    private int calculateAgility() {
        return Arrays.stream(this.gems).filter(Objects::nonNull).mapToInt(GemType::getAgility).sum();
    }

    private int calculateVitality() {
        return Arrays.stream(this.gems).filter(Objects::nonNull).mapToInt(GemType::getVitality).sum();
    }

    private int calculateMinDamage() {
        return this.getType().getMinDamage() + 2 * this.calculateStrength()
                + this.calculateAgility();
    }

    private int calculateMaxDamage() {
        return this.getType().getMaxDamage() + 3 * this.calculateStrength() +
                4 * this.calculateAgility();
    }

    private double calculateLevel() {
        return (this.calculateMinDamage() + this.calculateMaxDamage()) / 2d +
                this.calculateStrength() + this.calculateAgility() + this.calculateVitality();
    }

    public void add(String gemType, int index) {
        if (index < 0 || index >= this.gems.length) {
            throw new IllegalArgumentException("Invalid index.");
        }

        GemType gem = GemType.valueOf(gemType);

        this.gems[index] = gem;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.gems.length) {
            throw new IllegalArgumentException("Invalid index.");
        }

        this.gems[index] = null;
    }

    public String printComparable() {
        return this.toString() + String.format(" (Item Level: %.1f)", this.calculateLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(),
                this.calculateMinDamage(),
                this.calculateMaxDamage(),
                this.calculateStrength(),
                this.calculateAgility(),
                this.calculateVitality());
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.calculateLevel(), o.calculateLevel());
    }
}
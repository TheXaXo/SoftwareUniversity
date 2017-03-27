package infernoInfinity;

public enum Weapon {

    AXE(5, 10, 4), SWORD(4, 6, 3), KNIFE(3, 4, 2);

    private String name;
    private int minDamage;
    private int maxDamage;
    private int socketsCount;
    private Gem[] socketContains;

    private int strength;
    private int agility;
    private int vitality;

    private Weapon(int minDamage, int maxDamage, int sockets) {
        this.setMinDamage(minDamage);
        this.setMaxDamage(maxDamage);
        this.setSocketsCount(sockets);
        this.socketContains = new Gem[this.getSocketsCount()];
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    private void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    private void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getSocketsCount() {
        return this.socketsCount;
    }

    private void setSocketsCount(int socketsCount) {
        this.socketsCount = socketsCount;
    }

    private int getStrength() {
        return this.strength;
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }

    private int getAgility() {
        return this.agility;
    }

    private void setAgility(int agility) {
        this.agility = agility;
    }

    private int getVitality() {
        return this.vitality;
    }

    private void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public void add(Gem gem, int index) {
        if (index < 0 || index >= this.getSocketsCount()) {
            throw new IllegalArgumentException("Invalid index.");
        }

        if (this.socketContains[index] != null) {
            this.remove(index);
        }

        this.socketContains[index] = gem;

        this.setMinDamage(this.getMinDamage() + 2 * gem.getStrength() + gem.getAgility());
        this.setMaxDamage(this.getMaxDamage() + 3 * gem.getStrength() + 4 * gem.getAgility());

        this.setStrength(this.getStrength() + gem.getStrength());
        this.setAgility(this.getAgility() + gem.getAgility());
        this.setVitality(this.getVitality() + gem.getVitality());
    }

    public void remove(int index) {
        if (index < 0 || index >= this.getSocketsCount()) {
            throw new IllegalArgumentException("Invalid index.");
        }

        if (this.socketContains[index] != null) {
            Gem gemToBeRemoved = this.socketContains[index];

            this.setMinDamage(this.getMinDamage() - 2 * gemToBeRemoved.getStrength() - gemToBeRemoved.getAgility());
            this.setMaxDamage(this.getMaxDamage() - 3 * gemToBeRemoved.getStrength() - 4 * gemToBeRemoved.getAgility());

            this.setStrength(this.getStrength() - gemToBeRemoved.getStrength());
            this.setAgility(this.getAgility() - gemToBeRemoved.getAgility());
            this.setVitality(this.getVitality() - gemToBeRemoved.getVitality());
        }

        this.socketContains[index] = null;
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(), this.getMinDamage(), this.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality());
    }
}
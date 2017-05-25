package bg.softuni.core;

public class Tracker {

    private int damageFixed;
    private int casualtiesSaved;
    private int casesProcessed;

    public void fixDamage(int damage) {
        this.damageFixed += damage;
    }

    public void saveCasualties(int casualtiesSaved) {
        this.casualtiesSaved += casualtiesSaved;
    }

    public void processCase() {
        this.casesProcessed++;
    }

    public int getDamageFixed() {
        return this.damageFixed;
    }

    public int getCasualtiesSaved() {
        return this.casualtiesSaved;
    }

    public int getSpecialCasesProcessed() {
        return this.casesProcessed;
    }
}
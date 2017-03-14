import java.util.ArrayList;

public abstract class Center {

    private String name;
    private ArrayList<Animal> storedAnimals;

    protected Center(String name) {
        this.setName(name);
        this.setStoredAnimals(new ArrayList<>());
    }

    public final String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public final ArrayList<Animal> getStoredAnimals() {
        return this.storedAnimals;
    }

    public void setStoredAnimals(ArrayList<Animal> storedAnimals) {
        this.storedAnimals = storedAnimals;
    }
}
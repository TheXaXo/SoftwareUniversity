import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private HashMap<String, CleansingCenter> cleansingCenters;
    private HashMap<String, AdoptionCenter> adoptionCenters;
    private HashMap<String, CastrationCenter> castrationCenters;

    private ArrayList<String> adoptedAnimals;
    private ArrayList<String> cleansedAnimals;
    private ArrayList<String> castratedAnimals;

    public AnimalCenterManager() {
        this.setCleansingCenters(new HashMap<>());
        this.setAdoptionCenters(new HashMap<>());
        this.setCastrationCenters(new HashMap<>());

        this.adoptedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
    }

    public HashMap<String, CastrationCenter> getCastrationCenters() {
        return this.castrationCenters;
    }

    private void setCastrationCenters(HashMap<String, CastrationCenter> castrationCenters) {
        this.castrationCenters = castrationCenters;
    }

    private void addCleansingCenter(CleansingCenter cleansingCenter) {
        this.cleansingCenters.put(cleansingCenter.getName(), cleansingCenter);
    }

    public HashMap<String, CleansingCenter> getCleansingCenters() {
        return this.cleansingCenters;
    }

    private void setCleansingCenters(HashMap<String, CleansingCenter> cleansingCenters) {
        this.cleansingCenters = cleansingCenters;
    }

    public HashMap<String, AdoptionCenter> getAdoptionCenters() {
        return this.adoptionCenters;
    }

    private void setAdoptionCenters(HashMap<String, AdoptionCenter> adoptionCenters) {
        this.adoptionCenters = adoptionCenters;
    }

    private void addAdoptionCenter(AdoptionCenter adoptionCenter) {
        this.adoptionCenters.put(adoptionCenter.getName(), adoptionCenter);
    }

    public void registerCleansingCenter(String name) {
        this.addCleansingCenter(new CleansingCenter(name));
    }

    public void registerAdoptionCenter(String name) {
        this.addAdoptionCenter(new AdoptionCenter(name));
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, learnedCommands);

        this.getAdoptionCenters().get(adoptionCenterName).getStoredAnimals().add(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, intelligenceCoefficient);

        this.getAdoptionCenters().get(adoptionCenterName).getStoredAnimals().add(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        ArrayList<Animal> animalsToSend = this.adoptionCenters.get(adoptionCenterName).getStoredAnimals().stream()
                .filter(animal -> !animal.isCleansingStatus())
                .collect(Collectors.toCollection(ArrayList::new));

        for (Animal animal : animalsToSend) {
            this.getCleansingCenters().get(cleansingCenterName).getStoredAnimals().add(animal);
        }
    }

    public void cleanse(String cleansingCenterName) {
        ArrayList<Animal> cleansedAnimals = new ArrayList<>(this.getCleansingCenters().get(cleansingCenterName).getStoredAnimals());
        this.getCleansingCenters().get(cleansingCenterName).setStoredAnimals(new ArrayList<>());

        for (Animal animal : cleansedAnimals) {
            animal.setCleansingStatus(true);

            this.cleansedAnimals.add(animal.getName());
        }
    }

    public void adopt(String adoptionCenterName) {
        ArrayList<Animal> animalsToAdopt = this.getAdoptionCenters().get(adoptionCenterName).getStoredAnimals().stream()
                .filter(Animal::isCleansingStatus)
                .collect(Collectors.toCollection(ArrayList::new));

        for (Animal animal : animalsToAdopt) {
            this.getAdoptionCenters().get(adoptionCenterName).getStoredAnimals().remove(animal);

            this.adoptedAnimals.add(animal.getName());
        }
    }

    public void printStatistics() {
        StringBuilder adoptedAnimalsStr = new StringBuilder();

        this.adoptedAnimals = this.adoptedAnimals.stream()
                .sorted(Comparator.comparing(animal -> animal))
                .collect(Collectors.toCollection(ArrayList::new));

        if (this.adoptedAnimals.size() != 0) {
            for (String animal : this.adoptedAnimals) {
                adoptedAnimalsStr.append(animal).append(", ");
            }

            adoptedAnimalsStr = new StringBuilder(adoptedAnimalsStr.substring(0, adoptedAnimalsStr.length() - 2));
        } else {
            adoptedAnimalsStr.append("None");
        }

        StringBuilder cleansedAnimalsStr = new StringBuilder();

        this.cleansedAnimals = this.cleansedAnimals.stream()
                .sorted(Collator.getInstance())
                .collect(Collectors.toCollection(ArrayList::new));

        if (this.cleansedAnimals.size() != 0) {
            for (String animal : this.cleansedAnimals) {
                cleansedAnimalsStr.append(animal).append(", ");
            }

            cleansedAnimalsStr = new StringBuilder(cleansedAnimalsStr.substring(0, cleansedAnimalsStr.length() - 2));
        } else {
            cleansedAnimalsStr.append("None");
        }

        System.out.printf("Paw Incorporative Regular Statistics%n" +
                        "Adoption Centers: %d%n" +
                        "Cleansing Centers: %d%n" +
                        "Adopted Animals: %s%n" +
                        "Cleansed Animals: %s%n" +
                        "Animals Awaiting Adoption: %d%n" +
                        "Animals Awaiting Cleansing: %d%n",
                this.getAdoptionCenters().size(),
                this.getCleansingCenters().size(),
                adoptedAnimalsStr,
                cleansedAnimalsStr,
                this.getAdoptionCenters().values().stream()
                        .mapToLong(center -> center.getStoredAnimals().stream().filter(Animal::isCleansingStatus).count())
                        .sum(),
                this.getCleansingCenters().values().stream()
                        .mapToLong(center -> center.getStoredAnimals().stream().filter(animal -> !animal.isCleansingStatus()).count())
                        .sum()
        );
    }

    public void registerCastrarionCenter(String name) {
        this.getCastrationCenters().put(name, new CastrationCenter(name));
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        ArrayList<Animal> animalsSentToCastration = this.getAdoptionCenters().get(adoptionCenterName).getStoredAnimals().stream()
                .filter(animal -> !animal.isCleansingStatus())
                .collect(Collectors.toCollection(ArrayList::new));

        this.getCastrationCenters().get(castrationCenterName).getStoredAnimals().addAll(animalsSentToCastration);
    }

    public void castrate(String castrationCenterName) {
        ArrayList<Animal> animals = new ArrayList<>(this.getCastrationCenters().get(castrationCenterName).getStoredAnimals());

        for (Animal animal : animals) {
            this.castratedAnimals.add(animal.getName());

            this.getCastrationCenters().get(castrationCenterName).getStoredAnimals().remove(animal);
        }
    }

    public void castrationStatistics() {
        StringBuilder castratedAnimalsStr = new StringBuilder();

        this.castratedAnimals = this.castratedAnimals.stream()
                .sorted(Collator.getInstance())
                .collect(Collectors.toCollection(ArrayList::new));

        for (String animalName : this.castratedAnimals) {
            castratedAnimalsStr.append(animalName).append(", ");
        }

        if (castratedAnimalsStr.length() != 0) {
            castratedAnimalsStr = new StringBuilder(castratedAnimalsStr.substring(0, castratedAnimalsStr.length() - 2));
        } else {
            castratedAnimalsStr.append("None");
        }

        System.out.printf("Paw Inc. Regular Castration Statistics%n" +
                        "Castration Centers: %d%n" +
                        "Castrated Animals: %s%n",
                this.getCastrationCenters().size(),
                castratedAnimalsStr);
    }
}
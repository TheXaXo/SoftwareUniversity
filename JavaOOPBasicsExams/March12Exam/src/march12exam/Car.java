package march12exam;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model,
               int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
    }

    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    private void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    private void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getOverallPerformance() {
        return (this.getHorsepower() / this.getAcceleration()) + (this.getSuspension() + this.getDurability());
    }

    public int getEnginePerformance() {
        return this.getHorsepower() / this.getAcceleration();
    }

    public int getSuspensionPerformance() {
        return this.getSuspension() + this.getDurability();
    }

    public int getTimePerformance(TimeLimitRace race) {
        return race.getLength() * ((this.getHorsepower() / 100) * this.getAcceleration());
    }

    public void increaseHorsePower(int horsePower) {
        this.setHorsepower(horsePower);
    }

    public void updateSuspension(int suspension) {
        this.setSuspension(suspension);
    }

    public void tune(int tuneIndex, String tuneAddOn) {
        this.increaseHorsePower(this.getHorsepower() + tuneIndex);
        this.updateSuspension(this.getSuspension() + (tuneIndex / 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %d%n", this.getBrand(), this.getModel(), this.getYearOfProduction()));
        sb.append(String.format("%d HP, 100 m/h in %d s%n", this.getHorsepower(), this.getAcceleration()));
        sb.append(String.format("%d Suspension force, %d Durability%n", this.getSuspension(), this.getDurability()));

        return sb.toString();
    }
}
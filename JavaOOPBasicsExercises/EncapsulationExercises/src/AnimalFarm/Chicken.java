package AnimalFarm;

public class Chicken {
    private String name;
    private int age;
    private String productsPerDay;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.setProductsPerDay(age);
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalStateException("Name cannot be empty.");
        }

        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age <= 0 || age >= 15) {
            throw new IllegalStateException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    private String getProductsPerDay() {
        return this.productsPerDay;
    }

    private void setProductsPerDay(int age) {
        if (age < 6) {
            this.productsPerDay = "2";
        } else if (age < 12) {
            this.productsPerDay = "1";
        } else {
            this.productsPerDay = "0.75";
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.getName(), this.getAge(), this.getProductsPerDay());
    }
}
package march12exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformanceCar extends Car {

    private ArrayList<String> addOns;

    public PerformanceCar(String brand, String model,
                          int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction,
                horsepower + (horsepower * 50) / 100, acceleration, suspension - (suspension * 25) / 100, durability);
        this.setAddOns(new ArrayList<>());
    }

    public List<String> getAddOns() {
        return Collections.unmodifiableList(this.addOns);
    }

    private String getAddonsString() {
        if (this.getAddOns().isEmpty()) {
            return "None";
        }

        return String.join(", ", this.getAddOns());
    }

    public void setAddOns(ArrayList<String> addOns) {
        this.addOns = addOns;
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);
        this.addOns.add(tuneAddOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Add-ons: %s", this.getAddonsString()));

        return sb.toString();
    }
}
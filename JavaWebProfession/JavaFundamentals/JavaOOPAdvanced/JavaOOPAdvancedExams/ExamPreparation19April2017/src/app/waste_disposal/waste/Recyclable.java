package app.waste_disposal.waste;

import app.waste_disposal.annotations.RecyclingRequired;

@RecyclingRequired
public class Recyclable extends BaseWaste {

    public Recyclable(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}

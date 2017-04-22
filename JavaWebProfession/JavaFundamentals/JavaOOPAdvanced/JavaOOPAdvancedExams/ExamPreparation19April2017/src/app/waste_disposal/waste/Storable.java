package app.waste_disposal.waste;

import app.waste_disposal.annotations.StoringRequired;

@StoringRequired
public class Storable extends BaseWaste {

    public Storable(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
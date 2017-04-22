package app.waste_disposal.waste;

import app.waste_disposal.annotations.BurningRequired;

@BurningRequired()
public class Burnable extends BaseWaste {

    public Burnable(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}

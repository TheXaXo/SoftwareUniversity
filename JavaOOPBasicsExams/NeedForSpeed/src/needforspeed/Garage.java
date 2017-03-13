package needforspeed;

import java.util.*;

public class Garage {

    private ArrayList<Car> parkedCars;

    public Garage() {
        this.setParkedCars(new ArrayList<>());
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(this.parkedCars);
    }

    private void setParkedCars(ArrayList<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void addCar(Car car) {
        this.parkedCars.add(car);
    }

    public void removeCar(Car car) {
        this.parkedCars.remove(car);
    }
}

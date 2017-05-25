package Ferrari;

public class Ferrari implements Car {

    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    private String getDriverName() {
        return this.driverName;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String useGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", Car.MODEL, this.useBrakes(), this.useGas(), this.getDriverName());
    }
}
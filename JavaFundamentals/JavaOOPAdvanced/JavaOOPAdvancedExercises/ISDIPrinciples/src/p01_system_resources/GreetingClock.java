package p01_system_resources;

public class GreetingClock {

    private TimeProvider timeProvider;
    private Printer printer;

    public GreetingClock(TimeProvider timeProvider, Printer printer) {
        this.timeProvider = timeProvider;
        this.printer = printer;
    }

    public void greeting() {
        if (this.timeProvider.getHour() < 12) {
            this.printer.println("Good morning...");
        } else if (this.timeProvider.getHour() < 18) {
            this.printer.println("Good afternoon...");
        } else {
            this.printer.println("Good evening...");
        }
    }
}
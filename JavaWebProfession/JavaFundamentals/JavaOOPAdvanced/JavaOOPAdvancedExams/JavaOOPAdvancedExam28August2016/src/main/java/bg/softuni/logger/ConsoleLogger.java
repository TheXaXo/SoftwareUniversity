package bg.softuni.logger;

public class ConsoleLogger implements Logger {

    @Override
    public void println(String message) {
        System.out.println(message);
    }
}

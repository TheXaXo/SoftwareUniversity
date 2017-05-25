package logger;

public class EventLogger extends AbstractHandler {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ERROR || type == LogType.EVENT) {
            System.out.println(message);
        } else {
            super.passToSuccessor(type, message);
        }
    }
}
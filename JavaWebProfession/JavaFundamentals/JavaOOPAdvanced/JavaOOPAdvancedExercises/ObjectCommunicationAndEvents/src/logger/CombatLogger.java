package logger;

public class CombatLogger extends AbstractHandler {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ATTACK || type == LogType.MAGIC || type == LogType.TARGET) {
            System.out.println(message);
        } else {
            super.passToSuccessor(type, message);
        }
    }
}
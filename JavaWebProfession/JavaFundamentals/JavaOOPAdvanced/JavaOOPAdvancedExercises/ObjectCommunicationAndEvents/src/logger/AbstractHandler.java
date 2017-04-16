package logger;

public abstract class AbstractHandler implements Handler {

    private Handler successor;

    public void passToSuccessor(LogType type, String message) {
        if (this.successor != null) {
            this.successor.handle(type, message);
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
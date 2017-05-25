package warningLevels;

public class Message {

    private Importance level;
    private String message;

    public Message(String level, String message) {
        this.setLevel(level);
        this.setMessage(message);
    }

    private void setLevel(String level) {
        this.level = Importance.valueOf(level.toUpperCase());
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Importance getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return this.getLevel() + ": " + this.message;
    }
}
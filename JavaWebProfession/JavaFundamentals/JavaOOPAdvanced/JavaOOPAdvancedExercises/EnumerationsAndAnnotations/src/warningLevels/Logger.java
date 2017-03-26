package warningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private Importance threshold;
    private List<Message> messages;

    public Logger(String threshold) {
        this.setThreshold(threshold);
        this.messages = new ArrayList<>();
    }

    private void setThreshold(String threshold) {
        this.threshold = Importance.valueOf(threshold.toUpperCase());
    }

    public void receiveMessage(Message message) {
        if (message.getLevel().compareTo(this.threshold) >= 0) {
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}
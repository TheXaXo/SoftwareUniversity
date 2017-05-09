package avatar.commands;

public abstract class Command implements Executable {

    private String[] tokens;

    protected Command(String[] tokens) {
        this.tokens = tokens;
    }

    public String[] getTokens() {
        return this.tokens;
    }
}
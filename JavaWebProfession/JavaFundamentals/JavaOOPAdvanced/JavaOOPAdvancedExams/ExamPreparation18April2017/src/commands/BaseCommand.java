package commands;

public abstract class BaseCommand implements Executable {

    private String[] tokens;

    protected BaseCommand(String[] tokens) {
        this.tokens = tokens;
    }

    public String[] getTokens() {
        return this.tokens;
    }
}
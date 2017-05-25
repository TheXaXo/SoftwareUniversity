package app.waste_disposal.commands;

public abstract class BaseCommand implements Executable {

    private String[] tokens;

    protected BaseCommand(String[] tokens) {
        this.tokens = tokens;
    }

    protected String[] getTokens() {
        return this.tokens;
    }
}

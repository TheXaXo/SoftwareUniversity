package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import core.Tracker;
import io.Writer;

public class ProcessEmergenciesCommand extends BaseCommand {

    @InjectArgs
    private ManagementSystem system;

    @InjectArgs
    private Writer writer;

    @InjectArgs
    private Tracker tracker;

    public ProcessEmergenciesCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public void execute() {
        this.writer.write(this.system.processEmergencies(super.getTokens()[1], this.tracker));
    }
}
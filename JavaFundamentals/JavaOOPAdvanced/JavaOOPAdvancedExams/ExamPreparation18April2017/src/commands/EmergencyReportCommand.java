package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import core.Tracker;
import io.Writer;

public class EmergencyReportCommand extends BaseCommand {

    @InjectArgs
    private ManagementSystem system;

    @InjectArgs
    private Writer writer;

    @InjectArgs
    private Tracker tracker;

    public EmergencyReportCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public void execute() {
        this.writer.write(this.system.emergencyReport(this.tracker));
    }
}
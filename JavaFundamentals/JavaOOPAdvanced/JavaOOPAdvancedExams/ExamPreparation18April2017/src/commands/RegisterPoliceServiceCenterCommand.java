package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import io.Writer;
import models.centers.PoliceServiceCenter;

public class RegisterPoliceServiceCenterCommand extends BaseCommand {

    @InjectArgs
    private ManagementSystem system;

    @InjectArgs
    private Writer writer;

    public RegisterPoliceServiceCenterCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public void execute() {
        String[] tokens = super.getTokens();

        this.writer.write(this.system.registerServiceCenter(new PoliceServiceCenter(
                tokens[1],
                Integer.parseInt(tokens[2])
        )));
    }
}
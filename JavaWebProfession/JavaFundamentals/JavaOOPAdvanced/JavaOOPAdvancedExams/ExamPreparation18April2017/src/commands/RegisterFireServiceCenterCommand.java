package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import io.Writer;
import models.centers.FiremanServiceCenter;

public class RegisterFireServiceCenterCommand extends BaseCommand {

    @InjectArgs
    private ManagementSystem system;

    @InjectArgs
    private Writer writer;

    public RegisterFireServiceCenterCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public void execute() {
        String[] tokens = super.getTokens();

        this.writer.write(this.system.registerServiceCenter(
                new FiremanServiceCenter(tokens[1], Integer.parseInt(tokens[2]))));
    }
}
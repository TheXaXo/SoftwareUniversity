package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import io.Writer;
import models.emergencies.PropertyEmergency;
import utils.RegistrationTimeImpl;

public class RegisterPropertyEmergencyCommand extends BaseCommand {

    @InjectArgs
    private ManagementSystem system;

    @InjectArgs
    private Writer writer;

    public RegisterPropertyEmergencyCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public void execute() {
        String[] tokens = super.getTokens();

        this.writer.write(this.system.registerEmergency(new PropertyEmergency(
                tokens[1],
                EmergencyLevel.valueOf(tokens[2].toUpperCase()),
                new RegistrationTimeImpl(tokens[3]),
                Integer.parseInt(tokens[4])
        )));
    }
}
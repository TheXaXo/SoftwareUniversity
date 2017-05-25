package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import io.Writer;
import models.emergencies.HealthEmergency;
import utils.RegistrationTimeImpl;

public class RegisterHealthEmergencyCommand extends BaseCommand {

    @InjectArgs
    private ManagementSystem system;

    @InjectArgs
    private Writer writer;

    public RegisterHealthEmergencyCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public void execute() {
        String[] tokens = super.getTokens();

        this.writer.write(this.system.registerEmergency(new HealthEmergency(
                tokens[1],
                EmergencyLevel.valueOf(tokens[2].toUpperCase()),
                new RegistrationTimeImpl(tokens[3]),
                Integer.parseInt(tokens[4])
        )));
    }
}
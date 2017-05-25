package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import enums.Status;
import io.Writer;
import models.emergencies.OrderEmergency;
import utils.RegistrationTimeImpl;

public class RegisterOrderEmergencyCommand extends BaseCommand {

    @InjectArgs
    private ManagementSystem system;

    @InjectArgs
    private Writer writer;

    public RegisterOrderEmergencyCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public void execute() {
        String[] tokens = super.getTokens();

        this.writer.write(this.system.registerEmergency(new OrderEmergency(
                tokens[1],
                EmergencyLevel.valueOf(tokens[2].toUpperCase()),
                new RegistrationTimeImpl(tokens[3]),
                Status.valueOf(tokens[4].toUpperCase().replaceAll("\\-", ""))
        )));
    }
}
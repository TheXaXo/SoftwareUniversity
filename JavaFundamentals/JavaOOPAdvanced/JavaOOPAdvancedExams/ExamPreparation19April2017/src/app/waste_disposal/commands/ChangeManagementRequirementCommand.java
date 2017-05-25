package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.models.ManagementRequirement;

import java.lang.reflect.InvocationTargetException;

public class ChangeManagementRequirementCommand extends BaseCommand {

    @Inject
    private ManagementRequirement managementRequirement;

    public ChangeManagementRequirementCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = super.getTokens();

        this.managementRequirement.setActive(true);
        this.managementRequirement.setMinEnergyBalance(Double.parseDouble(tokens[0]));
        this.managementRequirement.setMinCapital(Double.parseDouble(tokens[1]));
        this.managementRequirement.setBannedGarbageType(tokens[2]);

        return "Management requirement changed!";
    }
}
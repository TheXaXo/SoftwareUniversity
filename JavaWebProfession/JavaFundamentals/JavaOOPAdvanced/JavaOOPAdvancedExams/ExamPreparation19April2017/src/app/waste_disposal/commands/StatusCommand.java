package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.repository.Repository;

public class StatusCommand extends BaseCommand {

    @Inject
    private Repository repository;

    public StatusCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public String execute() {
        return String.format("Energy: %.2f Capital: %.2f", this.repository.getEnergy(), this.repository.getCapital());
    }
}
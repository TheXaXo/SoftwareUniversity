package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.ManagementRequirement;
import app.waste_disposal.repository.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProcessGarbageCommand extends BaseCommand {

    private static final String CLASSES_PATH = "app.waste_disposal.waste.";

    @Inject
    private GarbageProcessor garbageProcessor;
    @Inject
    private Repository repository;
    @Inject
    private ManagementRequirement managementRequirement;

    public ProcessGarbageCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = super.getTokens();

        String name = tokens[0];
        double weight = Double.parseDouble(tokens[1]);
        double volumePerKg = Double.parseDouble(tokens[2]);
        String type = tokens[3];

        Class<Waste> wasteClass = (Class<Waste>) Class.forName(CLASSES_PATH + type);
        Constructor<Waste> constructor = wasteClass.getDeclaredConstructor(String.class, double.class, double.class);

        Waste garbageObject = constructor.newInstance(name, weight, volumePerKg);

        if (this.managementRequirement.isActive() &&
                this.managementRequirement.getBannedGarbageType().equals(garbageObject.getClass().getSimpleName()) &&
                (this.repository.getCapital() < this.managementRequirement.getMinCapital() ||
                        this.repository.getEnergy() < this.managementRequirement.getMinEnergyBalance())) {
            return "Processing Denied!";
        }

        ProcessingData data = this.garbageProcessor.processWaste(garbageObject);
        this.repository.addEnergy(data.getEnergyBalance());
        this.repository.addCapital(data.getCapitalBalance());

        return String.format("%.2f kg of %s successfully processed!", weight, name);
    }
}
package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.contracts.Repository;
import barracksWars.contracts.Unit;
import barracksWars.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = super.getData()[1];

        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);

        String output = unitType + " added!";
        return output;
    }
}
package barracksWars.core.commands;

import barracksWars.annotations.ClassName;
import barracksWars.annotations.Inject;
import barracksWars.contracts.Repository;

import java.lang.reflect.InvocationTargetException;

@ClassName("retire")
public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            repository.removeUnit(super.getData()[1]);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
        return String.format("%s retired!", super.getData()[1]);
    }
}
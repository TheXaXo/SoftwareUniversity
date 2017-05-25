package cresla.managers;

import cresla.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private static final String REACTORS_PACKAGE = "cresla.entities.reactors.";
    private static final String REACTOR_SUFFIX = "Reactor";
    private static final String MODULES_PACKAGE = "cresla.entities.modules.";

    private Map<Integer, Reactor> reactorId;
    private Map<Integer, Module> moduleId;
    private int lastId;
    private int cryoReactorsCount;
    private int heatReactorsCount;
    private int energyModulesCount;
    private int absorbingModulesCount;

    public ManagerImpl() {
        this.reactorId = new LinkedHashMap<>();
        this.moduleId = new LinkedHashMap<>();
        this.lastId = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String reactorCommand(List<String> arguments) {
        String reactorType = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));
        int moduleCapacity = Integer.parseInt(arguments.get(3));

        try {
            Class<Reactor> reactorClass =
                    (Class<Reactor>) Class.forName(REACTORS_PACKAGE + reactorType + REACTOR_SUFFIX);
            Constructor<Reactor> constructor =
                    (Constructor<Reactor>) reactorClass.getDeclaredConstructors()[0];

            Reactor reactorObject = constructor.newInstance(++this.lastId, additionalParameter, moduleCapacity);

            this.reactorId.putIfAbsent(lastId, reactorObject);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        if (reactorType.equals("Cryo")) {
            this.cryoReactorsCount++;
        } else {
            this.heatReactorsCount++;
        }

        return String.format("Created %s Reactor - %d", reactorType, this.lastId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(1));
        String type = arguments.get(2);
        int additionalParameter = Integer.parseInt(arguments.get(3));

        try {
            Class<Module> moduleClass = (Class<Module>) Class.forName(MODULES_PACKAGE + type);
            Constructor<Module> constructor = (Constructor<Module>) moduleClass.getDeclaredConstructors()[0];

            if (type.equals("CryogenRod")) {
                EnergyModule moduleObject = (EnergyModule) constructor.newInstance(++this.lastId, additionalParameter);
                this.reactorId.get(reactorId).addEnergyModule(moduleObject);
                this.moduleId.putIfAbsent(this.lastId, moduleObject);
                this.energyModulesCount++;
            } else {
                AbsorbingModule moduleObject = (AbsorbingModule) constructor.newInstance(++this.lastId, additionalParameter);
                this.reactorId.get(reactorId).addAbsorbingModule(moduleObject);
                this.moduleId.putIfAbsent(this.lastId, moduleObject);
                this.absorbingModulesCount++;
            }
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        return String.format("Added %s - %d to Reactor - %d", type, this.lastId, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int itemId = Integer.parseInt(arguments.get(1));

        if (this.reactorId.containsKey(itemId)) {
            return this.reactorId.get(itemId).toString();
        } else if (this.moduleId.containsKey(itemId)) {
            return this.moduleId.get(itemId).toString();
        }

        throw new IllegalArgumentException("Invalid id!");
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return String.format("Cryo Reactors: %d\nHeat Reactors: %d\n" +
                        "Energy Modules: %d\nAbsorbing Modules: %d\n" +
                        "Total Energy Output: %d\nTotal Heat Absorbing: %d",
                this.cryoReactorsCount,
                this.heatReactorsCount,
                this.energyModulesCount,
                this.absorbingModulesCount,
                this.reactorId.values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum(),
                this.reactorId.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum());
    }
}
package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BaseReactor implements Reactor {

    private static final String CONTAINER_CLASS_PATH = "cresla.entities.containers.ModuleContainer";

    private int id;
    private Container container;

    protected BaseReactor(int id, int moduleCapacity) {
        this.id = id;
        this.container = new ModuleContainer(moduleCapacity);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() {
        try {
            Class<Container> containerClass = (Class<Container>) Class.forName(CONTAINER_CLASS_PATH);
            Method modulesCountMethod = containerClass.getDeclaredMethod("getModulesCount");
            modulesCountMethod.setAccessible(true);

            return (int) modulesCountMethod.invoke(this.container);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Wrong modules added to reactor!");
        }
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }
}
package tests;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class ModuleContainerShould {

    private static final int CAPACITY = 1;
    private static final int CAPACITY_FOR_SECOND_MODULE_CONTAINER = 2;
    private static final int EXPECTED_CAPACITY = 1;
    private static final int EXPECTED_CAPACITY_AFTER_REMOVING = 1;
    private static final int ENERGY_MODULE_ENERGY_OUTPUT = 10;
    private static final int ABSORBING_MODULE_HEAT_ABSORBING = 20;
    private static final long EXPECTED_TOTAL_ENERGY_OUTPUT = 10;
    private static final long EXPECTED_TOTAL_HEAT_ABSORBING = 20;
    private static final long EXPECTED_TOTAL_ENERGY_OUTPUT_WITH_NO_MODULES = 0;
    private static final long EXPECTED_TOTAL_HEAT_ABSORBING_WITH_NO_MODULES = 0;

    private Container moduleContainer;
    private Container moduleContainerForTestingTheInputOrder;
    private EnergyModule energyModule;
    private EnergyModule energyModuleTwo;
    private AbsorbingModule absorbingModule;
    private AbsorbingModule absorbingModuleTwo;

    @Before
    public void initialize() {
        this.moduleContainer = new ModuleContainer(CAPACITY);
        this.moduleContainerForTestingTheInputOrder = new ModuleContainer(CAPACITY_FOR_SECOND_MODULE_CONTAINER);
        this.energyModule = Mockito.mock(EnergyModule.class);
        this.energyModuleTwo = Mockito.mock(EnergyModule.class);
        this.absorbingModule = Mockito.mock(AbsorbingModule.class);
        this.absorbingModuleTwo = Mockito.mock(AbsorbingModule.class);

        Mockito.when(this.energyModule.getId()).thenReturn(1);
        Mockito.when(this.energyModuleTwo.getId()).thenReturn(2);

        Mockito.when(this.absorbingModule.getId()).thenReturn(3);
        Mockito.when(this.absorbingModuleTwo.getId()).thenReturn(4);

        Mockito.when(this.energyModule.getEnergyOutput()).thenReturn(ENERGY_MODULE_ENERGY_OUTPUT);
        Mockito.when(this.absorbingModule.getHeatAbsorbing()).thenReturn(ABSORBING_MODULE_HEAT_ABSORBING);
    }

    @Test
    public void addEnergyModule() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainer.addEnergyModule(this.energyModule);
        Assert.assertEquals("Module was not added successfully!", EXPECTED_CAPACITY, this.getEnergyModules().size());
    }

    @Test
    public void addEnergyModuleToTheListKeepingTheOrderOfEntrance() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainerForTestingTheInputOrder.addEnergyModule(this.energyModule);
        Assert.assertEquals("The energy module was not added to the list keeping the order!",
                EXPECTED_CAPACITY, this.getModulesByInput().size());
    }

    @Test
    public void addAbsorbingModule() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainer.addAbsorbingModule(this.absorbingModule);
        Assert.assertEquals("Module was not added successfully!", EXPECTED_CAPACITY, this.getAbsorbingModules().size());
    }

    @Test
    public void addAbsorbingModuleToTheListKeepingTheOrderOfEntrance() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainerForTestingTheInputOrder.addAbsorbingModule(this.absorbingModule);
        Assert.assertEquals("The absorbing module was not added to the list keeping the order!",
                EXPECTED_CAPACITY, this.getModulesByInput().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionUponAddingNullEnergyModule() {
        this.moduleContainer.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionUponAddingNullAbsorbingModule() {
        this.moduleContainer.addAbsorbingModule(null);
    }

    @Test
    public void removeEnergyModuleIfOverCapacity() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainer.addEnergyModule(this.energyModule);
        this.moduleContainer.addEnergyModule(this.energyModuleTwo);

        Assert.assertEquals("The module is not being removed when over capacity!",
                EXPECTED_CAPACITY_AFTER_REMOVING, this.getEnergyModules().size());
    }

    @Test
    public void removeAbsorbingModuleIfOverCapacity() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainer.addAbsorbingModule(this.absorbingModule);
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleTwo);

        Assert.assertEquals("The module is not being removed when over capacity!",
                EXPECTED_CAPACITY_AFTER_REMOVING, this.getAbsorbingModules().size());
    }

    @Test
    public void removeModuleFromTheListKeepingTheOrderIfOverCapacity() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainerForTestingTheInputOrder.addEnergyModule(this.energyModule);
        this.moduleContainerForTestingTheInputOrder.addEnergyModule(this.energyModuleTwo);
        this.moduleContainerForTestingTheInputOrder.addAbsorbingModule(this.absorbingModule);

        Assert.assertEquals("The module was not removed from the list keeping the order!",
                CAPACITY_FOR_SECOND_MODULE_CONTAINER, this.getModulesByInput().size());
    }

    @Test
    public void returnCorrectTotalEnergyOutput() {
        this.moduleContainer.addEnergyModule(this.energyModule);

        Assert.assertEquals("The total energy output returned is wrong!",
                EXPECTED_TOTAL_ENERGY_OUTPUT, this.moduleContainer.getTotalEnergyOutput());
    }

    @Test
    public void returnCorrectTotalHeatAbsorbing() {
        this.moduleContainer.addAbsorbingModule(this.absorbingModule);

        Assert.assertEquals("The total heat absorbing returned is wrong!",
                EXPECTED_TOTAL_HEAT_ABSORBING, this.moduleContainer.getTotalHeatAbsorbing());
    }

    @Test
    public void removeTheFirstModuleEnteredIfOverCapacity() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainer.addEnergyModule(this.energyModule);
        this.moduleContainer.addEnergyModule(this.energyModuleTwo);

        Assert.assertTrue("The removed module was not the first one entered!",
                this.energyModuleTwo.equals(this.getEnergyModules().stream().findFirst().orElse(null)));
    }

    @Test
    public void removeTheFirstModuleEnteredIfOverCapacityFromTheListKeepingTheOrder() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainerForTestingTheInputOrder.addEnergyModule(this.energyModule);
        this.moduleContainerForTestingTheInputOrder.addEnergyModule(this.energyModuleTwo);
        this.moduleContainerForTestingTheInputOrder.addAbsorbingModule(this.absorbingModule);

        Assert.assertTrue("The removed module from the list keeping the order was not the first one entered!",
                this.energyModuleTwo.equals(this.getModulesByInput().getFirst()));
    }

    @Test
    public void preserveTheOrderOfModules() throws NoSuchFieldException, IllegalAccessException {
        this.moduleContainerForTestingTheInputOrder.addEnergyModule(this.energyModule);
        this.moduleContainerForTestingTheInputOrder.addEnergyModule(this.energyModuleTwo);

        Assert.assertTrue("The order of the modules was not preserved!",
                this.getModulesByInput().get(0).equals(this.energyModule) &&
                        this.getModulesByInput().get(1).equals(this.energyModuleTwo));
    }

    @Test
    public void returnZeroTotalEnergyOutputWithNoModules() {
        Assert.assertEquals("The total energy output returned was wrong!",
                EXPECTED_TOTAL_ENERGY_OUTPUT_WITH_NO_MODULES, this.moduleContainer.getTotalEnergyOutput());
    }

    @Test
    public void returnZeroTotalHeatAbsorbingWithNoModules() {
        Assert.assertEquals("The total heat absorbing returned was wrong!",
                EXPECTED_TOTAL_HEAT_ABSORBING_WITH_NO_MODULES, this.moduleContainer.getTotalHeatAbsorbing());
    }

    @SuppressWarnings("unchecked")
    private Collection<EnergyModule> getEnergyModules() throws NoSuchFieldException, IllegalAccessException {
        Class<Container> containerClass = (Class<Container>) this.moduleContainer.getClass();
        Field energyModulesField = containerClass.getDeclaredField("energyModules");
        energyModulesField.setAccessible(true);

        Map<Integer, EnergyModule> energyModulesMap =
                (Map<Integer, EnergyModule>) energyModulesField.get(this.moduleContainer);

        return energyModulesMap.values();
    }

    @SuppressWarnings("unchecked")
    private Collection<EnergyModule> getAbsorbingModules() throws NoSuchFieldException, IllegalAccessException {
        Class<Container> containerClass = (Class<Container>) this.moduleContainer.getClass();
        Field absorbingModulesField = containerClass.getDeclaredField("absorbingModules");
        absorbingModulesField.setAccessible(true);

        Map<Integer, EnergyModule> absorbingModulesMap =
                (Map<Integer, EnergyModule>) absorbingModulesField.get(this.moduleContainer);

        return absorbingModulesMap.values();
    }

    @SuppressWarnings("unchecked")
    private LinkedList<Module> getModulesByInput() throws NoSuchFieldException, IllegalAccessException {
        Class<Container> containerClass = (Class<Container>) this.moduleContainerForTestingTheInputOrder.getClass();
        Field modulesByInputField = containerClass.getDeclaredField("modulesByInput");
        modulesByInputField.setAccessible(true);

        LinkedList<Module> modulesByInput = (LinkedList<Module>) modulesByInputField.get(this.moduleContainerForTestingTheInputOrder);
        return modulesByInput;
    }
}
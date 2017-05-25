package bg.softuni.core;

import bg.softuni.contracts.Center;
import bg.softuni.contracts.Emergency;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.logger.Logger;
import bg.softuni.models.emergencies.HealthEmergency;
import bg.softuni.models.emergencies.OrderEmergency;
import bg.softuni.models.emergencies.PropertyEmergency;
import bg.softuni.utils.RegistrationTime;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter {

    private EmergencyManagementSystem system;
    private Logger logger;
    private Tracker tracker;

    public CommandInterpreter(EmergencyManagementSystem system, Logger logger, Tracker tracker) {
        this.system = system;
        this.logger = logger;
        this.tracker = tracker;
    }

    @SuppressWarnings("unchecked")
    public void interpretCommand(String[] tokens) throws
            ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        if (tokens[0].endsWith("Center")) {
            Class<Center> classToInitialize =
                    (Class<Center>) Class.forName("bg.softuni.models.centers." + tokens[0].substring(8));

            Constructor<Center> constructor = classToInitialize.getDeclaredConstructor(String.class, Integer.class);

            this.logger.println(
                    this.system.registerServiceCenter(constructor.newInstance(tokens[1], Integer.parseInt(tokens[2]))));
        } else {
            switch (tokens[0]) {
                case "RegisterPropertyEmergency":
                    Emergency emergency = new PropertyEmergency(
                            tokens[1],
                            EmergencyLevel.valueOf(tokens[2].toUpperCase()),
                            new RegistrationTime(tokens[3]),
                            Integer.parseInt(tokens[4]));

                    this.logger.println(this.system.registerEmergency(emergency));
                    break;

                case "RegisterHealthEmergency":
                    emergency = new HealthEmergency(
                            tokens[1],
                            EmergencyLevel.valueOf(tokens[2].toUpperCase()),
                            new RegistrationTime(tokens[3]),
                            Integer.parseInt(tokens[4]));

                    this.logger.println(this.system.registerEmergency(emergency));
                    break;

                case "RegisterOrderEmergency":
                    emergency = new OrderEmergency(
                            tokens[1],
                            EmergencyLevel.valueOf(tokens[2].toUpperCase()),
                            new RegistrationTime(tokens[3]),
                            tokens[4]);

                    this.logger.println(this.system.registerEmergency(emergency));
                    break;

                case "ProcessEmergencies":
                    this.logger.println(this.system.processEmergencies(tokens[1], this.tracker));
                    break;

                case "EmergencyReport":
                    this.logger.println(this.system.emergencyReport(tracker));
                    break;
            }
        }
    }
}
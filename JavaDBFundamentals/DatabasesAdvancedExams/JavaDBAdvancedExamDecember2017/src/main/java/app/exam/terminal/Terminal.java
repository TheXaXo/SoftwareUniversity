package app.exam.terminal;

import app.exam.config.Config;
import app.exam.controller.EmployeesController;
import app.exam.controller.ItemsController;
import app.exam.controller.OrdersController;
import app.exam.io.interfaces.ConsoleIO;
import app.exam.io.interfaces.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {
    private FileIO fileParser;
    private ConsoleIO consoleIO;
    private EmployeesController employeesController;
    private ItemsController itemsController;
    private OrdersController ordersController;

    @Autowired
    public Terminal(FileIO fileParser, ConsoleIO consoleIO, EmployeesController employeesController, ItemsController itemsController, OrdersController ordersController) {
        this.fileParser = fileParser;
        this.consoleIO = consoleIO;
        this.employeesController = employeesController;
        this.itemsController = itemsController;
        this.ordersController = ordersController;
    }

    @Override
    public void run(String... args) throws Exception {
        this.consoleIO.write(this.employeesController.importDataFromJSON(this.fileParser.read(Config.EMPLOYEES_IMPORT_JSON)));
        this.consoleIO.write(this.itemsController.importDataFromJSON(this.fileParser.read(Config.ITEMS_IMPORT_JSON)));
        this.consoleIO.write(this.ordersController.importDataFromXML(this.fileParser.read(Config.ORDERS_IMPORT_XML)));
        this.consoleIO.write(this.ordersController.exportOrdersByEmployeeAndOrderType("Avery Rush", "ToGo"));
    }
}
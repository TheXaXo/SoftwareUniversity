package app.exam.controller;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.parser.interfaces.Parser;
import app.exam.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeesController {
    private EmployeeServiceImpl employeeService;
    private Parser jsonParser;

    @Autowired
    public EmployeesController(EmployeeServiceImpl employeeService, @Qualifier(value = "JSONParser") Parser jsonParser) {
        this.employeeService = employeeService;
        this.jsonParser = jsonParser;
    }

    public String importDataFromJSON(String jsonContent) {
        EmployeeJSONImportDTO[] employeesDtos = null;
        StringBuilder sb = new StringBuilder();

        try {
            employeesDtos = this.jsonParser.read(EmployeeJSONImportDTO[].class, jsonContent);
        } catch (Exception e) {
            sb.append("Error: Invalid data.");
            sb.append(System.lineSeparator());
        }

        for (EmployeeJSONImportDTO employeeJSONImportDTO : employeesDtos) {
            try {
                this.employeeService.create(employeeJSONImportDTO);
                sb.append(String.format("Record %s successfully imported.", employeeJSONImportDTO.getName()));
                sb.append(System.lineSeparator());
            } catch (Exception e) {
                sb.append("Error: Invalid data.");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
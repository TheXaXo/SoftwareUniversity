package app.exam.service;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.domain.entities.Employee;
import app.exam.domain.entities.Position;
import app.exam.domain.entities.ValidationUtil;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.EmployeeRepository;
import app.exam.repository.PositionRepository;
import app.exam.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;
    private ModelParser modelParser;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository, ModelParser modelParser) {
        this.employeeRepository = employeeRepository;
        this.modelParser = modelParser;
        this.positionRepository = positionRepository;
    }

    @Override
    public void create(EmployeeJSONImportDTO importDTO) {
        String positionName = importDTO.getPositionName();
        Position position = this.positionRepository.findFirstByName(positionName);
        Position positionToAssign;

        if (position == null) {
            positionToAssign = new Position();
            positionToAssign.setName(positionName);
        } else {
            positionToAssign = position;
        }

        Employee employee = this.modelParser.convert(importDTO, Employee.class);
        employee.setPosition(positionToAssign);

        if (ValidationUtil.isValid(employee) && position == null) {
            this.positionRepository.saveAndFlush(positionToAssign);
        } else if (!ValidationUtil.isValid(employee)) {
            throw new IllegalArgumentException("Employee is invalid.");
        }

        this.employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void createMany(EmployeeJSONImportDTO[] importDTO) {

    }
}
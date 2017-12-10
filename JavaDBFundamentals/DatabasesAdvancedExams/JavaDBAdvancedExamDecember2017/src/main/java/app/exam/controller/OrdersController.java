package app.exam.controller;

import app.exam.domain.dto.xml.OrderWrapperXMLImportDTO;
import app.exam.domain.dto.xml.OrderXMLImportDTO;
import app.exam.parser.interfaces.Parser;
import app.exam.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class OrdersController {
    private Parser xmlParser;
    private OrderServiceImpl orderService;
    private Parser jsonParser;

    @Autowired
    public OrdersController(@Qualifier(value = "XMLParser") Parser xmlParser, OrderServiceImpl orderService, @Qualifier(value = "JSONParser") Parser jsonParser) {
        this.xmlParser = xmlParser;
        this.orderService = orderService;
        this.jsonParser = jsonParser;
    }

    public String importDataFromXML(String xmlContent) {
        OrderWrapperXMLImportDTO ordersDtos = null;

        StringBuilder sb = new StringBuilder();

        try {
            ordersDtos = this.xmlParser.read(OrderWrapperXMLImportDTO.class, xmlContent);
        } catch (Exception e) {
            sb.append("Error: Invalid data.");
        }

        for (OrderXMLImportDTO orderDto : ordersDtos.getOrders()) {
            try {
                this.orderService.create(orderDto);
                sb.append(String.format("Order for %s on %s added.", orderDto.getCustomer(), orderDto.getDateString()));
                sb.append(System.lineSeparator());
            } catch (Exception e) {
                sb.append("Error: Invalid data.");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

    public String exportOrdersByEmployeeAndOrderType(String employeeName, String orderType) throws IOException, JAXBException {
        return this.jsonParser.write(this.orderService.exportOrdersByEmployeeAndOrderType(employeeName, orderType));
    }
}

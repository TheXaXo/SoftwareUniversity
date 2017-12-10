package app.exam.controller;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.parser.interfaces.Parser;
import app.exam.service.ItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ItemsController {
    private ItemsServiceImpl itemsService;
    private Parser jsonParser;

    @Autowired
    public ItemsController(ItemsServiceImpl itemsService, @Qualifier(value = "JSONParser") Parser jsonParser) {
        this.itemsService = itemsService;
        this.jsonParser = jsonParser;
    }

    public String importDataFromJSON(String jsonContent) {
        ItemJSONImportDTO[] itemsDtos = null;
        StringBuilder sb = new StringBuilder();

        try {
            itemsDtos = this.jsonParser.read(ItemJSONImportDTO[].class, jsonContent);
        } catch (Exception e) {
            sb.append("Error: Invalid data.");
            sb.append(System.lineSeparator());
        }

        for (ItemJSONImportDTO itemDto : itemsDtos) {
            try {
                this.itemsService.create(itemDto);
                sb.append(String.format("Record %s successfully imported.", itemDto.getName()));
                sb.append(System.lineSeparator());
            } catch (Exception e) {
                sb.append("Error: Invalid data.");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
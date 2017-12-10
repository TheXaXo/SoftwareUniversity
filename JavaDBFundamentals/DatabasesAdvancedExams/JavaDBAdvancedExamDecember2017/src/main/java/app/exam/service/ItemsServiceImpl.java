package app.exam.service;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.domain.entities.Category;
import app.exam.domain.entities.Item;
import app.exam.domain.entities.ValidationUtil;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.CategoryRepository;
import app.exam.repository.ItemsRepository;
import app.exam.service.api.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {
    private ItemsRepository itemsRepository;
    private CategoryRepository categoryRepository;
    private ModelParser modelParser;

    @Autowired
    public ItemsServiceImpl(ItemsRepository itemsRepository, CategoryRepository categoryRepository, ModelParser modelParser) {
        this.itemsRepository = itemsRepository;
        this.categoryRepository = categoryRepository;
        this.modelParser = modelParser;
    }

    @Override
    public void create(ItemJSONImportDTO importDTO) {
        if (this.itemsRepository.findFirstByName(importDTO.getName()) != null) {
            throw new IllegalArgumentException("Item with the same name already exists.");
        }

        String categoryName = importDTO.getCategoryName();
        Category category = this.categoryRepository.findFirstByName(categoryName);
        Category categoryToAssign;

        if (category == null) {
            categoryToAssign = new Category();
            categoryToAssign.setName(categoryName);
        } else {
            categoryToAssign = category;
        }

        Item item = this.modelParser.convert(importDTO, Item.class);
        item.setCategory(categoryToAssign);

        if (ValidationUtil.isValid(item) && category == null) {
            this.categoryRepository.saveAndFlush(categoryToAssign);
        } else if (!ValidationUtil.isValid(item)) {
            throw new IllegalArgumentException("Item is invalid.");
        }

        this.itemsRepository.saveAndFlush(item);
    }
}
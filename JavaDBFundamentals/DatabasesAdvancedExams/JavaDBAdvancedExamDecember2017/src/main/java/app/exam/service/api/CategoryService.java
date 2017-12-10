package app.exam.service.api;

import app.exam.domain.dto.xml.CategoriesFrequentItemsXMLExportDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    CategoriesFrequentItemsXMLExportDTO getCategoriesWithMostPopularItems(List<String> categoryNames);
}
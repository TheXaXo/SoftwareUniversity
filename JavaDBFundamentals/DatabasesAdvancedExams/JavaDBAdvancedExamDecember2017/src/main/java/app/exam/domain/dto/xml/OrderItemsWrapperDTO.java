package app.exam.domain.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItemsWrapperDTO {
    @XmlElement(name = "item")
    private List<OrderItemXMLImportDTO> items;

    public List<OrderItemXMLImportDTO> getItems() {
        return this.items;
    }

    public void setItems(List<OrderItemXMLImportDTO> items) {
        this.items = items;
    }
}
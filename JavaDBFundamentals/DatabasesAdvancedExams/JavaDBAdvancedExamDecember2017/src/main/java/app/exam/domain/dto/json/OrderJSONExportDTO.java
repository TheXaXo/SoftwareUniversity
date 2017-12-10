package app.exam.domain.dto.json;


import com.google.gson.annotations.Expose;

import java.util.List;

public class OrderJSONExportDTO {
    @Expose
    private String customer;

    @Expose
    private List<ItemJSONExportDTO> items;

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<ItemJSONExportDTO> getItems() {
        return this.items;
    }

    public void setItems(List<ItemJSONExportDTO> items) {
        this.items = items;
    }
}
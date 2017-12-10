package app.exam.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class EmployeeOrdersJSONExportDTO implements Serializable {
    @Expose
    private String employeeName;

    @Expose
    private List<OrderJSONExportDTO> orders;

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<OrderJSONExportDTO> getOrders() {
        return this.orders;
    }

    public void setOrders(List<OrderJSONExportDTO> orders) {
        this.orders = orders;
    }
}

package app.exam.domain.dto.xml;

import app.exam.domain.entities.OrderType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrderXMLImportDTO {
    @XmlElement(name = "customer")
    private String customer;

    @XmlElement(name = "employee")
    private String employee;

    @XmlElement(name = "date")
    private String dateString;

    @XmlElement(name = "type")
    private OrderType type;

    @XmlElement(name = "items")
    private OrderItemsWrapperDTO orderItems;

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return this.employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public OrderType getType() {
        return this.type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public OrderItemsWrapperDTO getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(OrderItemsWrapperDTO orderItems) {
        this.orderItems = orderItems;
    }

    public String getDateString() {
        return this.dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
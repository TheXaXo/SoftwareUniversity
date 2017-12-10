package app.exam.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer", nullable = false)
    @NotNull
    private String customer;

    @Column(name = "date", nullable = false)
    @NotNull
    private Date date;

    @Column(name = "order_type", nullable = false)
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private OrderType type;

    //Says it should be required
    @Transient
    private BigDecimal totalPrice;

    @Transient
    private int itemsCount;

    @ManyToOne(optional = false)
    @NotNull
    private Employee employee;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderItem> orderItems;

    public Order() {
        this.type = OrderType.ForHere;
        this.totalPrice = new BigDecimal(0);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderType getType() {
        return this.type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = new BigDecimal(0);

        for (OrderItem orderItem : this.orderItems) {
            int quantity = orderItem.getQuantity();
            BigDecimal itemPrice = orderItem.getItem().getPrice();
            BigDecimal currentTotal = itemPrice.multiply(new BigDecimal(quantity));

            total = total.add(currentTotal);
        }

        return total;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public int getItemsCount() {
        if (this.orderItems == null) {
            return 0;
        }

        return this.orderItems.size();
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }
}
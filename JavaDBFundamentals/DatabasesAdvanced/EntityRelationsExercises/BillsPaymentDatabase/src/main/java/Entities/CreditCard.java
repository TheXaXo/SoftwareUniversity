package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {
    @Column(name = "type")
    private String type;

    @Column(name = "expiration_date")
    private Date expirationDate;

    public CreditCard(long number, User owner, String type, Date expirationDate) {
        super(number, owner);
        this.type = type;
        this.expirationDate = expirationDate;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
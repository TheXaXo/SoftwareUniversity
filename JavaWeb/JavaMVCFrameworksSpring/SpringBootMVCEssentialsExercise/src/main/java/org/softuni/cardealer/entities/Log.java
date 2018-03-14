package org.softuni.cardealer.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String user;

    @Column
    private String operation;

    @Column
    private String modifiedTable;

    @Column
    private Date date;

    public Log() {

    }

    public Log(String user, String operation, String modifiedTable, Date date) {
        this.user = user;
        this.operation = operation;
        this.modifiedTable = modifiedTable;
        this.date = date;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getModifiedTable() {
        return this.modifiedTable;
    }

    public void setModifiedTable(String modifiedTable) {
        this.modifiedTable = modifiedTable;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
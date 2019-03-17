package com.upcprovision.calc.model.tickets;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


@Component
public class TicketStatus implements Serializable {

    public TicketStatus() {
    }

    public TicketStatus(String username, String statusUpdate, Date date) {
        this.username = username;
        this.statusUpdate = statusUpdate;
        this.date = date;
    }

    private String username;
    private String statusUpdate;
    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

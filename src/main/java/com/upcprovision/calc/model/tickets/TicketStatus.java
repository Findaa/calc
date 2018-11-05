package com.upcprovision.calc.model.tickets;


import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component

public class TicketStatus implements Serializable {

    private String username;
    private String statusUpdate;



    public TicketStatus() {
    }

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

}

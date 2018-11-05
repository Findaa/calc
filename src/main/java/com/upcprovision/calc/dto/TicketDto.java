package com.upcprovision.calc.dto;

import com.upcprovision.calc.model.tickets.TicketStatus;

import java.io.Serializable;
import java.util.ArrayList;

public class TicketDto implements Serializable {

    private Long id;
    private ArrayList<TicketStatus> ticketStatuses;

    private int clientid;
    private boolean closed = false;
    private String currentgroup;
    private String username;
    private String statusUpdate;
    private String ticketCreator;
    private String closedString;

    public TicketDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<TicketStatus> getTicketStatuses() {
        return ticketStatuses;
    }

    public void setTicketStatuses(ArrayList<TicketStatus> ticketStatuses) {
        this.ticketStatuses = ticketStatuses;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getCurrentgroup() {
        return currentgroup;
    }

    public void setCurrentgroup(String currentgroup) {
        this.currentgroup = currentgroup;
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

    public String getTicketCreator() {
        return ticketCreator;
    }

    public void setTicketCreator(String ticketCreator) {
        this.ticketCreator = ticketCreator;
    }

    public String getClosedString() {
        return closedString;
    }

    public void setClosedString(String closedString) {
        this.closedString = closedString;
    }
}

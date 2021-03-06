package com.upcprovision.calc.dto;

import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.security.user.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.util.ArrayList;

public class TicketDto implements Serializable {

    private Long id;
    private ArrayList<TicketStatus> ticketStatuses;
    private int clientId;
    private boolean closed = false;
    private String currentGroup;
    private String username;
    private String statusUpdate;
    private String ticketCreator;
    private String closedString;

    public String getAuthorityUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }


    public TicketDto() {
    }

    public TicketDto(boolean closed, String currentGroup, String statusUpdate) {
        this.username = getAuthorityUsername();
        this.closed = closed;
        this.currentGroup = currentGroup;
        this.statusUpdate = statusUpdate;
    }

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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getCurrentGroup() {
        return currentGroup;
    }

    public void setCurrentGroup(String currentGroup) {
        this.currentGroup = currentGroup;
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

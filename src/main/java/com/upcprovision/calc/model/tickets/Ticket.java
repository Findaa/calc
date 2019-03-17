package com.upcprovision.calc.model.tickets;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;


@Component
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticket_id")
    private Long id;
    @Lob
    private ArrayList<TicketStatus> ticketStatuses;
    private int clientId;
    private boolean closed = false;
    private String currentGroup;

    public Ticket(ArrayList<TicketStatus> ticketStatuses, int clientId, boolean closed, String currentGroup) {
        this.ticketStatuses = ticketStatuses;
        this.clientId = clientId;
        this.closed = closed;
        this.currentGroup = currentGroup;
    }

    public Ticket() {
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
}

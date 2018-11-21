package com.upcprovision.calc.model.tickets;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;



@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticket_id")
    private Long id;
    private ArrayList<TicketStatus> ticketStatuses;
    private int clientid;
    private boolean closed = false;
    private String currentgroup;

    public Ticket(ArrayList<TicketStatus> ticketStatuses, int clientid, boolean closed, String currentgroup) {
        this.ticketStatuses = ticketStatuses;
        this.clientid = clientid;
        this.closed = closed;
        this.currentgroup = currentgroup;
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
}

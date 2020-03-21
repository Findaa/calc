package com.upcprovision.calc.model.tickets;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;


@Component
@Entity
@Data
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

}

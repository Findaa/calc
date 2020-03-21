package com.upcprovision.calc.model.tickets;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Component
@Data
public class TicketStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticket_status_id")
    private Long id;
    private String username;
    private String statusUpdate;
    private Date date;

    public TicketStatus() {
    }
    public TicketStatus(String username, String statusUpdate, Date date) {
        this.username = username;
        this.statusUpdate = statusUpdate;
        this.date = date;
    }
}

package com.upcprovision.calc.model.tickets;



import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;


@Component
@Data
@Entity
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "client_id")
    Long id;
    private String street;
    private String building;
    private String flat;
    private String postalcode;
    private int phone;
    private int pesel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "client_ticket",
            joinColumns =
            @JoinColumn(name = "client_id"),
            inverseJoinColumns =
            @JoinColumn(name = "ticket_id"))
    private Set<Ticket> ticket;

    public Client() { }

    public Client(String street, String building, String flat, String postalcode, int phone, int pesel, Set<Ticket> ticket) {
        this.street = street;
        this.building = building;
        this.flat = flat;
        this.postalcode = postalcode;
        this.phone = phone;
        this.pesel = pesel;
        this.ticket = ticket;
    }
}


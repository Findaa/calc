package com.upcprovision.calc.model.tickets;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;


@Component
@Data
@Entity
public class Client {
    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = "client_id")
    Long id;
    @Getter
    @Setter
    private String street;
    @Getter
    @Setter
    private String building;
    @Getter
    @Setter
    private String flat;
    @Getter
    @Setter
    private String postalcode;
    @Getter
    @Setter
    private int phone;
    @Getter
    @Setter
    private int pesel;
    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "client_ticket",
            joinColumns =
            @JoinColumn(name = "client_id"),
            inverseJoinColumns =
            @JoinColumn(name = "ticket_id"))
    private Set<Ticket> ticket;

    public Client() {
    }

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


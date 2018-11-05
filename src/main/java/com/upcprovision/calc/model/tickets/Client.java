package com.upcprovision.calc.model.tickets;


import com.upcprovision.calc.model.tickets.Ticket;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Long getClient_id() {
        return id;
    }

    public void setClient_id(Long client_id) {
        this.id = client_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public Set<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(Set<Ticket> ticket) {
        this.ticket = ticket;
    }
}


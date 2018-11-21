package com.upcprovision.calc.repos.tickets;

import com.upcprovision.calc.dto.TicketDTO;
import com.upcprovision.calc.model.tickets.Ticket;

import java.util.List;

public interface TicketServices {
    List<Ticket> getTicket(String id);
    List<Ticket> getTicketByClient(String id);
    List<Ticket> getTicketsByUser(String id);
    List<Ticket> getTicketByTicketId(String id);
    Ticket getTicketObjectByTicketId(String id);
    void addTicket(TicketDTO ticketDto);
    List<TicketDTO> processTicketList(List<Ticket> ticketList);
    List<Ticket> getAll();
    TicketDTO editTicket(TicketDTO ticketDto);
}

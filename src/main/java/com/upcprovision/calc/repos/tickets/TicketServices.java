package com.upcprovision.calc.repos.tickets;

import com.upcprovision.calc.dto.TicketDto;
import com.upcprovision.calc.model.tickets.Ticket;

import java.util.List;


public interface TicketServices {
    /**getTicket provides automatic choice of id type
     *
     * @param id identifier of user tickets, ticket history, client tickets
     * @return either of getTicketBy methods
     */
    List<Ticket> getTicket(String id);


    List<Ticket> getTicketByClient(String id);
    List<Ticket> getTicketsByUser(String id);
    List<Ticket> getTicketByTicketId(String id);
    void addTicket(TicketDto ticketDto);
    List<TicketDto> processTicketList(List<Ticket> ticketList);
    List<Ticket> getAll();

}

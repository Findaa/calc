package com.upcprovision.calc.services.tickets;

import com.upcprovision.calc.dto.TicketDto;
import com.upcprovision.calc.model.tickets.Ticket;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public interface TicketServices {
    List<Ticket> getTicket(String id);
    List<Ticket> getTicketByClient(String id);
    List<Ticket> getTicketsByUser(String id);
    List<Ticket> getTicketByTicketId(String id);
    Ticket getTicketObjectByTicketId(String id);
    void addTicket(TicketDto ticketDto);
    List<TicketDto> processTicketList(List<Ticket> ticketList);
    List<Ticket> getAll();
    TicketDto editTicket(TicketDto ticketDto);
    void addStatus(TicketDto ticketDTO, int id);
    List<Ticket> getAllByTimestamp(String timestamp);
}

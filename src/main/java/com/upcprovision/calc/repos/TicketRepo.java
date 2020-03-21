package com.upcprovision.calc.repos;

import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.model.tickets.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    Ticket findAllById(Long id);
    List<Ticket> findAllByClientId(int id);
    List<Ticket> findAllByTicketStatuses(TicketStatus ticketStatus);
    List<Ticket> findAllByCurrentGroup(String id);
}

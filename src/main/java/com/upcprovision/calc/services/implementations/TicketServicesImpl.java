package com.upcprovision.calc.services.implementations;


import com.upcprovision.calc.security.user.CustomUserDetails;
import com.upcprovision.calc.dto.TicketDto;
import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.repos.TicketRepo;
import com.upcprovision.calc.services.DateServices;
import com.upcprovision.calc.services.tickets.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class TicketServicesImpl implements TicketServices {

    private TicketRepo ticketRepo;
    private DateServices dateServices;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    @Autowired
    public TicketServicesImpl(TicketRepo ticketRepo, DateServices dateServices) {
        this.dateServices = dateServices;
        this.ticketRepo = ticketRepo;
    }

    @Override
    public List<TicketDto> processTicketList(List<Ticket> ticketList) {
        List<TicketDto> ticketDTOList = new ArrayList<>();

        ticketList.forEach(ticket -> {
            TicketDto ticketDto = new TicketDto();
            ArrayList<TicketStatus> ticketStatuses = ticket.getTicketStatuses();
            TicketStatus status = ticketStatuses.get(ticketStatuses.size() - 1);
            ticketDto.setId(ticket.getId());
            ticketDto.setStatusUpdate(status.getStatusUpdate());
            ticketDto.setUsername(status.getUsername());
            ticketDto.setCurrentGroup(ticket.getCurrentGroup());
            ticketDto.setClosed(ticket.isClosed());
            ticketDto.setTicketStatuses(ticketStatuses);
            ticketDto.setClientId(ticket.getClientId());
            ticketDto.setTicketCreator(ticketStatuses.get(ticketStatuses.size() - 1).getUsername());
            if (ticket.isClosed()) {
                ticketDto.setClosedString("Yes");
                if (ticketDto.getStatusUpdate().isEmpty()) {
                    ticketDto.setStatusUpdate("Closed by: " + getUsername());
                }
            } else {
                ticketDto.setClosedString("No");
            }
            ticketDTOList.add(ticketDto);
        });

        return ticketDTOList;
    }

    @Override
    public List<Ticket> getTicket(String id) {
        String checktt = "tt+[0-9]+";
        int var;
        if (Pattern.matches(checktt, id)) {
            var = 1;
        } else {
            boolean flag = true;
            try {
                int x = Integer.parseInt(id);
            } catch (NumberFormatException nfe) {
                flag = false;
            } finally {
                int x = 0;
            }
            if (!flag) {
                var = 2;
            } else {
                var = 3;
            }
        }

        if (var == 1) {
            return getTicketByTicketId(id);
        }
        if (var == 2) {
            return getTicketsByUser(id);
        } else {
            return getTicketByClient(id);
        }
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> getTicketByClient(String id) {
        try {
            return getAll().stream().filter(ticket ->
                    Integer.parseInt(Long.toString(ticket.getClientId())) == Integer.parseInt(id))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("ParseException");
            return null;
        }
    }

    @Override
    public List<Ticket> getTicketsByUser(String id) {
        return getAll().stream().filter(ticket ->
                ticket.getTicketStatuses().get(0).getUsername().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getTicketByTicketId(String id) throws ArithmeticException {
        StringBuilder ticketNumber = new StringBuilder(id);
        ticketNumber.delete(0, 2);
        Long ticketid;
        try {
            ticketid = Long.valueOf(ticketNumber.toString());
        } catch (ArithmeticException ae) {
            ticketid = 0L;
        }
        return Collections.singletonList(ticketRepo.findAllById(ticketid));
    }

    @Override
    public Ticket getTicketObjectByTicketId(String id) {
        return ticketRepo.findAllById(Long.parseLong(id));
    }

    @Override
    public void addTicket(TicketDto ticketDto) {
        TicketStatus ticketStatus = new TicketStatus();
        ArrayList<TicketStatus> list = new ArrayList<>();
        ticketStatus.setUsername(getUsername());
        ticketStatus.setStatusUpdate(ticketDto.getStatusUpdate());
        list.add(ticketStatus);
        Ticket ticket = new Ticket(list, ticketDto.getClientId(), ticketDto.isClosed(), ticketDto.getCurrentGroup());
        ticketRepo.save(ticket);
    }

    @Override
    public TicketDto editTicket(TicketDto ticketDto) {
        return null;
    }


    @Override
    public void addStatus(TicketDto ticketDTO, int id) {
        Ticket ticket = ticketRepo.findAllById((long) id);
        ArrayList<TicketStatus> statuses = ticket.getTicketStatuses();
        TicketStatus ticketStatus =
                new TicketStatus(getUsername(), ticketDTO.getStatusUpdate(), Date.from(Instant.now()));
        statuses.add(ticketStatus);
        ticket.setTicketStatuses(statuses);
        ticket.setClosed(ticketDTO.isClosed());
        ticket.setCurrentGroup(ticketDTO.getCurrentGroup());
        ticketRepo.save(ticket);
    }

    @Override
    public List<Ticket> getAllByTimestamp(String timestamp) {
        return getAll().stream().filter(ticket ->
                ticket
                        .getTicketStatuses().get(0).getDate()
                        .equals(dateServices.dateToArray(dateServices.stringToDate(timestamp)))).collect(Collectors.toList());
    }
}

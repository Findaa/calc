package com.upcprovision.calc.services;


import com.upcprovision.calc.model.CustomUserDetails;
import com.upcprovision.calc.dto.TicketDto;
import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.repos.tickets.TicketRepo;
import com.upcprovision.calc.repos.tickets.TicketServices;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class TicketServicesImpl implements TicketServices {
    private TicketRepo ticketRepo;
    public TicketServicesImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }
    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        return name;
    }


    @Override
    public List<TicketDto> processTicketList(List<Ticket> ticketList) {
        List<TicketDto> ticketDtoList = new ArrayList<>();

        for (int x = 0; x < ticketList.size(); x++) {
            TicketDto ticketDto = new TicketDto();

            Ticket ticket = ticketList.get(x);
            ArrayList<TicketStatus> ticketStatuses = ticket.getTicketStatuses();
            TicketStatus status = ticketStatuses.get(ticketStatuses.size() - 1);
            int i = 0;
            for (int z = 0; z < ticketList.size(); z++) {
                i++;
            }

            TicketStatus lastStatus = ticketStatuses.get(ticketStatuses.size() - 1);
            ticketDto.setId(ticket.getId());
            ticketDto.setStatusUpdate(status.getStatusUpdate());
            ticketDto.setUsername(status.getUsername());
            ticketDto.setCurrentgroup(ticket.getCurrentgroup());
            ticketDto.setClosed(ticket.isClosed());
            ticketDto.setTicketStatuses(ticketStatuses);
            ticketDto.setClientid(ticket.getClientid());
            ticketDto.setTicketCreator(lastStatus.getUsername());
            if (ticket.isClosed()) {
                ticketDto.setClosedString("Zamkniete");
            } else {
                ticketDto.setClosedString("Otwarte");
            }
            ticketDtoList.add(ticketDto);
        }
        return ticketDtoList;
    }


    @Override
    public List<Ticket> getTicket(String id) {
        List<Ticket> result = null;
        int var = 0;
        String checktt = "tt+[0-9]+";

        if (Pattern.matches(checktt, id)) {
            var = 1;
        } else if (!Pattern.matches("checktt", id)) {
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
            result = getTicketByTicketId(id);
        } else if (var == 2) {
            result = getTicketsByUser(id);
        } else if (var == 3) {
            result = getTicketByClient(id);
        }
        return result;
    }

    @Override
    public List<Ticket> getTicketByClient(String id) {
        return ticketRepo.findAllByClientid(Integer.parseInt(id));
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> getTicketsByUser(String id) {

        List<Ticket> all = getAll();
        ArrayList<Ticket> returnList = new ArrayList<>();

        for (int x = 0; x < all.size(); x++) {

            TicketStatus ticketStatus;
            List<TicketStatus> ticketStatuses;
            Ticket ticket = all.get(x);

            ticketStatuses = ticket.getTicketStatuses();

            ticketStatus = ticketStatuses.get(0);

            if (ticketStatus.getUsername().equals(id)) {
                returnList.add(ticket);
            }
        }
        return returnList;
    }

    @Override
    public List<Ticket> getTicketByTicketId(String id) {
        char[] tt = id.toCharArray();
        char[] ttid = new char[tt.length - 2];
        for (int i = 0; i < ttid.length; i++) {
            ttid[i] = tt[i + 2];
        }
        StringBuilder ticketnumber = new StringBuilder();

        for (int i = 0; i < ttid.length; i++) {
            ticketnumber.append(ttid[i]);
        }
        Long ticketid = Long.valueOf(ticketnumber.toString());
        return java.util.Arrays.asList(ticketRepo.findAllById(ticketid));

    }


    @Override
    public void addTicket(TicketDto ticketDto) {
        TicketStatus ticketStatus = new TicketStatus();
        ArrayList<TicketStatus> list = new ArrayList();
        ticketStatus.setUsername(getUsername());
        ticketStatus.setStatusUpdate(ticketDto.getStatusUpdate());
        list.add(ticketStatus);
        Ticket ticket = new Ticket(list, ticketDto.getClientid(), ticketDto.isClosed(), ticketDto.getCurrentgroup());
        ticketRepo.save(ticket);
    }
}

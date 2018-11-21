package com.upcprovision.calc.services.tickets;


import com.upcprovision.calc.security.CustomUserDetails;
import com.upcprovision.calc.dto.TicketDTO;
import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.repos.tickets.TicketRepo;
import com.upcprovision.calc.repos.tickets.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class TicketServicesImpl implements TicketServices {

    private TicketRepo ticketRepo;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        return name;
    }

    @Autowired
    public TicketServicesImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public List<TicketDTO> processTicketList(List<Ticket> ticketList) {
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        for (int x = 0; x < ticketList.size(); x++) {
            TicketDTO ticketDto = new TicketDTO();

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
            ticketDTOList.add(ticketDto);
        }
        return ticketDTOList;
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

        for (Ticket anAll : all) {
            TicketStatus ticketStatus;
            List<TicketStatus> ticketStatuses;
            ticketStatuses = anAll.getTicketStatuses();
            ticketStatus = ticketStatuses.get(0);

            if (ticketStatus.getUsername().equals(id)) { returnList.add(anAll); }
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
        return Collections.singletonList(ticketRepo.findAllById(ticketid));

    }

    @Override
    public Ticket getTicketObjectByTicketId(String id){
        return ticketRepo.findAllById(Long.parseLong(id));
    }

    @Override
    public void addTicket(TicketDTO ticketDto) {
        TicketStatus ticketStatus = new TicketStatus();
        ArrayList<TicketStatus> list = new ArrayList<>();
        ticketStatus.setUsername(getUsername());
        ticketStatus.setStatusUpdate(ticketDto.getStatusUpdate());
        list.add(ticketStatus);
        Ticket ticket = new Ticket(list, ticketDto.getClientid(), ticketDto.isClosed(), ticketDto.getCurrentgroup());
        ticketRepo.save(ticket);
    }

    @Override
    public TicketDTO editTicket(TicketDTO ticketDto){
        return null;
    }
}

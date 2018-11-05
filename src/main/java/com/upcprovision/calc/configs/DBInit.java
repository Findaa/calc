package com.upcprovision.calc.configs;

/**
 * TEST CLASS FOR DATABASE LOGIN
 */

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.model.Role;
import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.UserRepo;
import com.upcprovision.calc.services.DealsServices;
import com.upcprovision.calc.services.UtargCalc;
import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.repos.tickets.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {

    @Autowired
    UserRepo userRepo;

    @Autowired
    DealsServices dealsServices;

    @Autowired
    UtargCalc utargCalc;

    @Autowired
    TicketRepo ticketRepo;

    @PostConstruct
    public void initUsers() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER"));
        userRepo.save(new User("cop", BCrypt.hashpw("131", BCrypt.gensalt(11)), "Xdxd", 1, roles, 1));

    }

    @PostConstruct
    public void initSuper() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("LEADER"));
        userRepo.save(new User("leader", BCrypt.hashpw("wow", BCrypt.gensalt(11)), "Xdxdd", 1, roles, 99)); //LeaderID 99 -> Leader Account
    }

    @PostConstruct
    public void initSells() {
        for (Long i = 0L; i < 60L; i++) {
            Deals deal = new Deals(i, "cop", 14567, 10 + i, 2, true, true, false, false, 10, 10, 10, 10, 10);
            dealsServices.add(deal);
        }
    }

    @PostConstruct
    public void initTicket() {
        TicketStatus ticketStatus = new TicketStatus();
        ticketStatus.setStatusUpdate("chuj");
        ticketStatus.setUsername("cop");
        System.out.println(ticketStatus + " pc ticketstatus");
        ArrayList<TicketStatus> list = new ArrayList();
        list.add(ticketStatus);
        System.out.println(list + " pc list");
        Ticket ticket = new Ticket(list, 23301, false, "helpdesk");
        ticketRepo.save(ticket);
        ticket.setTicketStatuses(list);
    }
}

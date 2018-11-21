package com.upcprovision.calc.configs;

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.security.Role;
import com.upcprovision.calc.security.User;
import com.upcprovision.calc.security.UserRepo;
import com.upcprovision.calc.services.provision.DealsServices;
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
    public DBInit(UserRepo userRepo, DealsServices dealsServices, TicketRepo ticketRepo) {
        this.userRepo = userRepo;
        this.dealsServices = dealsServices;
        this.ticketRepo = ticketRepo;
    }

    private UserRepo userRepo;
    private DealsServices dealsServices;
    private TicketRepo ticketRepo;

    @PostConstruct
    public void initUsers() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER"));
        userRepo.save(new User("test", BCrypt.hashpw("131", BCrypt.gensalt(11)), "Xdxd", 1, roles, 1));

    }

    //LeaderID 99 == Leader Account
    @PostConstruct
    public void initSuper() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("LEADER"));
        userRepo.save(new User("leader", BCrypt.hashpw("wow", BCrypt.gensalt(11)), "Xdxdd", 1, roles, 99));
    }

    @PostConstruct
    public void initSells() {
        for (long i = 0L; i < 60L; i++) {
            Deals deal = new Deals(
                    i, "test", 14567, 10 + i, 2, true, true,
                    false, false, 10, 10, 10, 10, 10);
            dealsServices.add(deal);
        }
    }

    @PostConstruct
    public void initTicket() {
        TicketStatus ticketStatus = new TicketStatus();
        TicketStatus ticketStatus2 = new TicketStatus();
        ticketStatus.setStatusUpdate("chuj");
        ticketStatus2.setStatusUpdate("nie");
        ticketStatus.setUsername("cop");
        ticketStatus2.setUsername("wiem");
        System.out.println(ticketStatus + " pc ticketstatus");
        ArrayList<TicketStatus> list = new ArrayList();
        list.add(ticketStatus);
        list.add(ticketStatus2);
        System.out.println(list + " pc list");
        Ticket ticket = new Ticket(list, 23301, false, "helpdesk");
        ticketRepo.save(ticket);
        ticket.setTicketStatuses(list);
    }
}

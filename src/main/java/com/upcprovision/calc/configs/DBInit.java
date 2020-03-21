package com.upcprovision.calc.configs;

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.security.user.Role;
import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.UserRepo;
import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.repos.TicketRepo;
import com.upcprovision.calc.services.provision.DealsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.*;

@Component
public class DBInit {
    @Autowired
    public DBInit(UserRepo userRepo, TicketRepo ticketRepo, DealsServices dealsServices) {
        this.userRepo = userRepo;
        this.ticketRepo = ticketRepo;
        this.dealsServices = dealsServices;
    }

    private UserRepo userRepo;
    private TicketRepo ticketRepo;
    private DealsServices dealsServices;

    @PostConstruct
    public void initUsers() {
        Set<Role> roles = new HashSet<>();

        roles.add(new Role("USER"));
        userRepo.save(new User("test", BCrypt.hashpw("131", BCrypt.gensalt(11)), "Xdxd", true, roles, 1));

    }

    @PostConstruct
    public void initSuper() {
        Set<Role> roles = new HashSet<>();

        roles.add(new Role("LEADER"));
        userRepo.save(new User(
                "leader", BCrypt.hashpw("wow", BCrypt.gensalt(11)), "Xdxdd", true, roles, 99));
    }

    @PostConstruct
    public void initSells() {
        for (long i = 0L; i < 60L; i++) {
            dealsServices.add(new Deals(
                    i, "test", 14567, 10 + i, 2, true, true,
                    false, false, (int) i % 5, 10, 10, 10, 10));
        }
    }

    @PostConstruct
    public void initTicket() {
        TicketStatus ticketStatus = new TicketStatus();
        TicketStatus ticketStatus2 = new TicketStatus();
        ticketStatus.setStatusUpdate("LadneSlowo");
        ticketStatus2.setStatusUpdate("nie");
        ticketStatus.setUsername("cop");
        ticketStatus2.setUsername("wiem");
        ticketStatus.setDate(Date.from(Instant.now()));
        ticketStatus2.setDate(Date.from(Instant.now()));
        ArrayList<TicketStatus> list = new ArrayList();
        list.add(ticketStatus);
        list.add(ticketStatus2);
        Ticket ticket = new Ticket(list, 23301, false, "helpdesk");
        ticketRepo.save(ticket);
    }
}

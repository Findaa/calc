package com.upcprovision.calc.controller.api;

import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.services.tickets.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/db")
@CrossOrigin(origins = "http://localhost:3000")
public class RestDatabaseController {
    @Autowired
    public RestDatabaseController(TicketServices ticketServices) {
        this.services = ticketServices;
    }

    private TicketServices services;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/ticket")
    @ResponseBody
    public Ticket getTicket(@RequestParam(value = "id") String id) {
        System.out.println("Inside rest api controller ticket");
        return services.getTicket(id).get(0);
    }
}

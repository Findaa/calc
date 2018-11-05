package com.upcprovision.calc.controller.tickets;

import com.upcprovision.calc.dto.TicketDto;
import com.upcprovision.calc.repos.tickets.TicketServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketsDatabaseController {

    private TicketServices ticketServices;
    public TicketsDatabaseController(TicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }

    @GetMapping("/ticketapp/add")
    public String viewAddTicket(Model model){
        model.addAttribute("ticket", new TicketDto());
        return "ticket/add";
    }

    @PostMapping("/ticket/add")
    public String addTicket(@ModelAttribute("ticket") TicketDto ticketDto){
        System.out.println(ticketDto);
        ticketServices.addTicket(ticketDto);
        return "redirect:/ticketapp";
    }



}

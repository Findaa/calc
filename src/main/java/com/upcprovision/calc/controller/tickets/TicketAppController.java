package com.upcprovision.calc.controller.tickets;


import com.upcprovision.calc.repos.tickets.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

@Controller
public class TicketAppController {

    @Autowired
    public TicketAppController(TicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }

    private TicketServices ticketServices;

    @GetMapping("/ticketapp")
    public String viewIndex(Model model){
        model.addAttribute("id", new String());
        return "ticket/app";
    }

    @PostMapping("/ticketapp/view")
    public String processTicketRequest(@ModelAttribute("id") String id, HttpSession session){
        try {
            session.setAttribute("ticketlist", ticketServices.processTicketList(ticketServices.getTicket(id)));
        }catch (NullPointerException npe){
            npe.printStackTrace();
        }
        return "redirect:/ticketapp/get";
    }
}

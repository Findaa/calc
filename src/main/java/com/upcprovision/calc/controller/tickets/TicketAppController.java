package com.upcprovision.calc.controller.tickets;


import com.upcprovision.calc.dto.TicketDto;
import com.upcprovision.calc.repos.tickets.TicketServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TicketAppController {


    private TicketServices ticketServices;

    public TicketAppController(TicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }

    @GetMapping("/ticketapp")
    public String viewIndex(Model model){
        model.addAttribute("id", new String());
        return "ticket/app";
    }

    @PostMapping("/ticketapp/view")
    public String processTicketRequest(@ModelAttribute("id") String id, HttpSession session){
        try {
            session.setAttribute("ticketlist", ticketServices.processTicketList(ticketServices.getTicket(id)));
            System.out.println(ticketServices.getTicket(id));
        }catch (NullPointerException npe){}
        return "redirect:/ticketapp/get";
    }

    @GetMapping("/ticketapp/get")
    public String viewTicketList(){
        return "ticket/get";
    }

}

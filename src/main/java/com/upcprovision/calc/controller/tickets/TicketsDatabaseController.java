package com.upcprovision.calc.controller.tickets;

import com.upcprovision.calc.dto.TicketDTO;
import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.repos.tickets.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TicketsDatabaseController {

    private TicketServices ticketServices;

    @Autowired
    public TicketsDatabaseController(TicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }

    @GetMapping("/ticketapp/get")
    public String viewTicketList(){
        return "ticket/get";
    }

    @GetMapping("/ticketapp/add")
    public String viewAddTicket(Model model){
        model.addAttribute("ticket", new TicketDTO());
        return "ticket/add";
    }

    @PostMapping("/ticketapp/add")
    public String addTicket(@ModelAttribute("ticket") TicketDTO ticketDto){
        ticketServices.addTicket(ticketDto);
        return "redirect:/ticketapp";
    }

    @GetMapping("/ticketapp/viewticket={x}")
    public String viewEdit(@PathVariable String x, HttpSession session) {

        Ticket oldTicket = ticketServices.getTicket(x).get(0);
        List<TicketStatus> statuses = oldTicket.getTicketStatuses();

        session.setAttribute("statuses", statuses);
        session.setAttribute("oldTicket", oldTicket);

        if (ticketServices.getTicket(x).size() == 1) {
            session.setAttribute("oldTicket", oldTicket);

        } else {
            System.out.println("Ticket table != 1");
        }
        return "ticket/viewticket";
    }

    @PostMapping("/ticket/viewticket")
    public String editTicket(HttpSession session){
    int id = Integer.parseInt(session.getAttribute("ticketlistId").toString());
        return "redirect:/ticketapp/get?id="+id;
    }
}

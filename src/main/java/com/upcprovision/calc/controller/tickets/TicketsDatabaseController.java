package com.upcprovision.calc.controller.tickets;

import com.upcprovision.calc.dto.TicketDTO;
import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.repos.tickets.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TicketsDatabaseController {

    @Autowired
    public TicketsDatabaseController(TicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }

    private TicketServices ticketServices;


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
    public String viewEdit(@PathVariable String x, HttpSession session, Model model) {
        Ticket oldTicket = ticketServices.getTicket(x).get(0);
        List<TicketStatus> statuses = oldTicket.getTicketStatuses();
        model.addAttribute("ticket", new TicketDTO());
        session.setAttribute("statuses", statuses);
        session.setAttribute("oldTicket", oldTicket);
        session.setAttribute("ticketId", oldTicket.getId());
        session.setAttribute("statusUpdate", "");
        session.setAttribute("ticket", new TicketDTO());

        return "ticket/viewticket";
    }

    @PostMapping("/ticketapp/addStatus")
    public String editTicket(@ModelAttribute("ticket") TicketDTO modelTicket, HttpSession session, @SessionAttribute("statuses") List<TicketStatus> statuses) {

        String id = session.getAttribute("ticketId").toString();


        TicketDTO ticketDTO = new TicketDTO(
                modelTicket.isClosed(),
                modelTicket.getCurrentGroup(),
                modelTicket.getStatusUpdate());
        System.out.println("Username ticket dto: " + ticketDTO.getAuthorityUsername());
        ticketServices.addStatus(ticketDTO, Integer.parseInt(id.toString()));
        return "redirect:/ticketapp/viewticket=tt" + id;
    }
}

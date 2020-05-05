package com.upcprovision.calc.controller.tickets;


import com.upcprovision.calc.dto.TicketDto;
import com.upcprovision.calc.model.tickets.Ticket;
import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.services.tickets.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @GetMapping("/ticketapp/get")
    public String viewTicketList(){
        return "ticket/get";
    }

    @GetMapping("/ticketapp/add")
    public String viewAddTicket(Model model){
        model.addAttribute("ticket", new TicketDto());
        return "ticket/add";
    }

    @PostMapping("/ticketapp/add")
    public String addTicket(@ModelAttribute("ticket") TicketDto ticketDto){
        ticketServices.addTicket(ticketDto);
        return "redirect:/ticketapp";
    }

    @GetMapping("/ticketapp/viewticket={x}")
    public String viewEdit(@PathVariable String x, HttpSession session, Model model) {
        Ticket oldTicket = ticketServices.getTicket(x).get(0);
        List<TicketStatus> statuses = oldTicket.getTicketStatuses();
        model.addAttribute("ticket", new TicketDto());
        session.setAttribute("statuses", statuses);
        session.setAttribute("oldTicket", oldTicket);
        session.setAttribute("ticketId", oldTicket.getId());
        session.setAttribute("statusUpdate", "");
        session.setAttribute("ticket", new TicketDto());
        return "ticket/viewticket";
    }

    @PostMapping("/ticketapp/addStatus")
    public String editTicket(@ModelAttribute("ticket") TicketDto modelTicket, HttpSession session,
                             @SessionAttribute("statuses") List<TicketStatus> statuses) {
        String id = session.getAttribute("ticketId").toString();
        TicketDto ticketDTO = new TicketDto(
                modelTicket.isClosed(),
                modelTicket.getCurrentGroup(),
                modelTicket.getStatusUpdate());
        System.out.println("Username ticket dto: " + ticketDTO.getAuthorityUsername());
        ticketServices.addStatus(ticketDTO, Integer.parseInt(id.toString()));
        return "redirect:/ticketapp/viewticket=tt" + id;
    }



}

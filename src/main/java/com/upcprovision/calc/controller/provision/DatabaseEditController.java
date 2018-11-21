package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.security.CustomUserDetails;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.provision.ConvertService;
import com.upcprovision.calc.services.provision.DealsServices;
import com.upcprovision.calc.services.provision.ProvisionTotal;
import com.upcprovision.calc.services.provision.ProvisionSingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class DatabaseEditController {

    @Autowired
    public DatabaseEditController(ProvisionTotal provisionTotal, ProvisionSingle provisionSingle, DealsServices dealsServices, ConvertService convertService) {
        this.provisionSingle = provisionSingle;
        this.dealsServices = dealsServices;
        this.convertService = convertService;
        this.provisionTotal = provisionTotal;
    }

    private DealsServices dealsServices;
    private ConvertService convertService;
    private ProvisionSingle provisionSingle;
    private ProvisionTotal provisionTotal;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    @GetMapping("/app/getdealsdone/edit/{x}")
    public String viewEdit(@PathVariable double x, HttpSession session, Model model) {
        Long id = (long) x;
        Deals olddeal;
        olddeal = dealsServices.findAllById(id);
        model.addAttribute("newdeal", new Deals());
        model.addAttribute("deletedeal", new String());
        session.setAttribute("id", id.toString());
        session.setAttribute("olddeal", olddeal);
        return "edit";
    }

    @PostMapping("/app/edit")
    public String redirectDealsedit(@ModelAttribute("newdeal") DealsDTO newdeal, HttpSession session) {
        Long id = Long.valueOf(session.getAttribute("id").toString());
        dealsServices.add(convertService.convert(id, newdeal, provisionSingle));
        session.setAttribute("list", dealsServices.getByLog(getUsername()));
        session.setAttribute("numerlog", newdeal.getLog());
        session.setAttribute("total", provisionTotal.getTotalSales(provisionTotal.findAllByLog(newdeal.getLog())));
        session.setAttribute("confirm", new String());
        session.setAttribute("msg", "Edytowano Wpis "+id);
        return "redirect:/app/getdealsdone";
    }

    @PostMapping("/app/edit/delete")
    public String deleteDealsedit(@ModelAttribute("confirm") String confirm, HttpSession session) throws NullPointerException {
        String value = session.getAttribute("id").toString();
        Long id = Long.valueOf(value);
        if (confirm.equals(session.getAttribute("numerlog").toString()) && confirm.equals(getUsername())) {
            session.setAttribute("msg", "Usunieto wpis "+id);
            dealsServices.deleteById(id);}
         else {
            session.setAttribute("msg", "Nie udalo sie usunac.");
        }
        session.setAttribute("list", dealsServices.getByLog(getUsername()));
        session.setAttribute("numerlog", getUsername());
        session.setAttribute("total", provisionTotal.getTotalSales(provisionTotal.findAllByLog(getUsername())));
        return "redirect:/app/getdealsdone";
    }

    @GetMapping("/app/edited")
    public String viewEdited() {
        return "edited";
    }
}
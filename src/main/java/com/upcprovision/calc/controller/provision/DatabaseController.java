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
public class DatabaseController {

    @Autowired
    public DatabaseController(ProvisionSingle provisionSingle, ProvisionTotal provisionTotal, DealsServices dealsServices, ConvertService convertService) {
        this.provisionSingle = provisionSingle;
        this.provisionTotal = provisionTotal;
        this.dealsServices = dealsServices;
        this.convertService = convertService;
    }

    private ProvisionSingle provisionSingle;
    private ProvisionTotal provisionTotal;
    private DealsServices dealsServices;
    private ConvertService convertService;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();

    }

    @GetMapping("/app/useradd")
    public String getUserAdd(Model model) {
        model.addAttribute("deal", new Deals());
        return "useradd";
    }

    @PostMapping("/useradd")
    public String postUserAdd(@ModelAttribute("deal") DealsDTO deal, HttpSession session) {
        dealsServices.add(convertService.convert(deal, provisionSingle));
        session.setAttribute("list", dealsServices.getByLog(getUsername()));
        session.setAttribute("numerlog", getUsername());
        session.setAttribute("total", provisionTotal.getTotalSales(provisionTotal.findAllByLog(getUsername())));
        return "redirect:/app/getdealsdone";
    }

    @GetMapping("/app/getdeals")
    public String getDeals(HttpSession session) {
        session.setAttribute("list", dealsServices.getByLog(getUsername()));
        session.setAttribute("numerlog", getUsername());
        session.setAttribute("total", provisionTotal.getTotalSales(provisionTotal.findAllByLog(getUsername())));
        return "redirect:/app/getdealsdone";
    }

    @GetMapping("/app/getdealsdone")
    public String getDealsDoneProcess() { return "redirect:/app/dealslist"; }

    @GetMapping("/app/dealslist")
    public String getDealsDone() { return "getdealsdone"; }
}
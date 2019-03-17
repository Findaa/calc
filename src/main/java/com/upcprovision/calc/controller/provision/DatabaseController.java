package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.security.CustomUserDetails;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.provision.ConvertService;
import com.upcprovision.calc.services.provision.DealsServices;
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
    public DatabaseController(ProvisionSingle provisionSingle, DealsServices dealsServices,
                              ConvertService convertService, ControllerServices controllerServices) {
        this.provisionSingle = provisionSingle;
        this.dealsServices = dealsServices;
        this.convertService = convertService;
        this.controllerServices = controllerServices;
    }

    private ProvisionSingle provisionSingle;
    private DealsServices dealsServices;
    private ConvertService convertService;
    private ControllerServices controllerServices;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();

    }


    @GetMapping("/app/useradd")
    public String getUserAdd(Model model) {
        model.addAttribute("deal", new Deals());
        return "provision/dealadd";
    }


    @PostMapping("/app/useradd")
    public String postUserAdd(@ModelAttribute("deal") DealsDTO deal, HttpSession session) {
        dealsServices.add(convertService.convert(deal, provisionSingle));
        return controllerServices.setDealsAttribute(session);
    }

    @GetMapping("/app/getdeals")
    public String getDeals(HttpSession session) {
        return  controllerServices.setDealsAttribute(session);
    }

    @GetMapping("/app/getdealsdone")
    public String getDealsDoneProcess() { return "redirect:/app/dealslist"; }

    @GetMapping("/app/dealslist")
    public String getDealsDone() { return "provision/getdealsdone"; }
}
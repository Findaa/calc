package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.security.CustomUserDetails;
import com.upcprovision.calc.model.provision.Target;
import com.upcprovision.calc.services.provision.ProvisionFinal;
import com.upcprovision.calc.services.provision.ProvisionTotal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ProvisionFinalController {

    private ProvisionFinal provisionFinal;
    private ProvisionTotal provisionTotal;

    public ProvisionFinalController(ProvisionFinal provisionFinal, ProvisionTotal provisionTotal) {
        this.provisionFinal = provisionFinal;
        this.provisionTotal = provisionTotal;
    }

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    @GetMapping("/targetadd")
    public String getTargetAdd(Model model) {
        model.addAttribute("target", new Target());
        try {
            double a = provisionTotal.getTotalSales(provisionTotal.findAllByLog(getUsername()));
            model.addAttribute("total", a);
        } catch (NullPointerException e) {
            model.addAttribute("total", 0);
        }
        return "/targetadd";
    }

    @PostMapping("/targetadd")
    public String postTargetAdd(@ModelAttribute("target") Target target, HttpSession session) {
        session.setAttribute("result", provisionFinal.calc(0, target));
        session.setAttribute("resultwsp", provisionFinal.calc(1, target));
        session.setAttribute("result2", provisionFinal.calc(2, target));
        return "redirect:/provision";
    }

    @GetMapping("/provision")
    public String getProvision() {
        return "provision";
    }

}
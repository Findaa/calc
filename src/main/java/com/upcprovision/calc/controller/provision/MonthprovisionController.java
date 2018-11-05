package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.model.CustomUserDetails;
import com.upcprovision.calc.model.provision.Target;
import com.upcprovision.calc.services.TargetCalculator;
import com.upcprovision.calc.services.TotalSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MonthprovisionController {

    private TargetCalculator targetCalculator;
    private TotalSales totalSales;

    public MonthprovisionController(TargetCalculator targetCalculator, TotalSales totalSales) {
        this.targetCalculator = targetCalculator;
        this.totalSales = totalSales;
    }

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }


    @GetMapping("/targetadd")
    public String getTargetAdd(Model model) {
        model.addAttribute("target", new Target());
        try {
            double a = totalSales.getTotalSales(totalSales.findAllByLog(getUsername()));
            model.addAttribute("total", a);
        } catch (NullPointerException e) {
            model.addAttribute("total", 0);
        }
        return "/targetadd";
    }

    @PostMapping("/targetadd")
    public String postTargetAdd(@ModelAttribute("target") Target target, HttpSession session) {
        session.setAttribute("result", targetCalculator.calc(0, target));
        session.setAttribute("resultwsp", targetCalculator.calc(1, target));
        session.setAttribute("result2", targetCalculator.calc(2, target));
        return "redirect:/provision";
    }

    @GetMapping("/provision")
    public String getProvision() {
        return "provision";
    }
}

package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.controller.ControllerServices;
import com.upcprovision.calc.model.provision.Target;
import com.upcprovision.calc.services.provision.ProvisionCalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class FinalProvisionController {
    @Autowired
    public FinalProvisionController(ProvisionCalculatorServices provisionCalculatorServices, ControllerServices controllerServices) {
        this.provisionCalculatorServices = provisionCalculatorServices;
        this.controllerServices = controllerServices;
    }

    private ProvisionCalculatorServices provisionCalculatorServices;
    private ControllerServices controllerServices;

    @GetMapping("/targetadd")
    public String getTargetAdd(Model model) {
        model.addAttribute("target", new Target());
        try {
            double a = provisionCalculatorServices.getTotalSales(provisionCalculatorServices.findAllByLog(controllerServices.getUsername()));
            model.addAttribute("total", a);
        } catch (NullPointerException e) {
            model.addAttribute("total", 0);
        }
        return "provision/targetadd";
    }

    @PostMapping("/targetadd")
    public String postTargetAdd(@ModelAttribute("target") Target target, HttpSession session) {
        session.setAttribute("result", provisionCalculatorServices.calc(0, target));
        session.setAttribute("resultwsp", provisionCalculatorServices.calc(1, target));
        session.setAttribute("result2", provisionCalculatorServices.calc(2, target));
        return "redirect:/provision";
    }

    @GetMapping("/provision")
    public String getProvision() {
        return "provision/provision";
    }
}
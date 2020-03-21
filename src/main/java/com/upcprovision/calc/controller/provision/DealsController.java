package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.controller.ControllerServices;
import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.provision.ConvertServices;
import com.upcprovision.calc.services.provision.DealsServices;
import com.upcprovision.calc.services.provision.ProvisionCalculatorServices;
import com.upcprovision.calc.services.provision.ProvisionCalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class DealsController {
    @Autowired
    public DealsController(ProvisionCalculatorServices provisionCalculatorServices, DealsServices dealsServices,
                           ConvertServices convertServices, ControllerServices controllerServices) {
        this.provisionCalculatorServices = provisionCalculatorServices;
        this.dealsServices = dealsServices;
        this.convertServices = convertServices;
        this.controllerServices = controllerServices;
    }

    private DealsServices dealsServices;
    private ConvertServices convertServices;
    private ProvisionCalculatorServices provisionCalculatorServices;
    private ControllerServices controllerServices;

    @GetMapping("/app/useradd")
    public String getUserAdd(Model model) {
        model.addAttribute("deal", new Deals());
        return "provision/dealadd";
    }

    @PostMapping("/app/useradd")
    public String postUserAdd(@ModelAttribute("deal") DealsDTO deal, HttpSession session) {
        dealsServices.add(convertServices.convert(deal, provisionCalculatorServices));
        return controllerServices.setDealsAttribute(session);
    }

    @GetMapping("/app/getdeals")
    public String getDeals(HttpSession session) {
        return controllerServices.setDealsAttribute(session);
    }

    @GetMapping("/app/getdealsdone")
    public String getDealsDoneProcess() {
        return "redirect:/app/dealslist";
    }

    @GetMapping("/app/dealslist")
    public String getDealsDone() {
        return "provision/getdealsdone";
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
        return "provision/edit";
    }

    @PostMapping("/app/edit")
    public String redirectDealsedit(@ModelAttribute("newdeal") DealsDTO newdeal, HttpSession session) {
        Long id = Long.valueOf(session.getAttribute("id").toString());
        dealsServices.add(convertServices.convert(id, newdeal, provisionCalculatorServices));
        session.setAttribute("list", dealsServices.getByLog(controllerServices.getUsername()));
        session.setAttribute("numerlog", newdeal.getLog());
        session.setAttribute("total", provisionCalculatorServices.getTotalSales(provisionCalculatorServices.findAllByLog(newdeal.getLog())));
        session.setAttribute("confirm", "");
        session.setAttribute("msg", "Edytowano Wpis "+id);
        return "redirect:/app/getdealsdone";
    }

    @PostMapping("/app/edit/delete")
    public String deleteDealsedit(@ModelAttribute("confirm") String confirm, HttpSession session) throws NullPointerException {
        String value = session.getAttribute("id").toString();
        Long id = Long.valueOf(value);
        if (confirm.equals(session.getAttribute("numerlog").toString()) && confirm.equals(controllerServices.getUsername())) {
            session.setAttribute("msg", "Usunieto wpis "+id);
            dealsServices.deleteById(id);}
        else {
            session.setAttribute("msg", "Nie udalo sie usunac.");
        }
        return controllerServices.setDealsAttribute(session);
    }

    @GetMapping("/app/edited")
    public String viewEdited() {
        return "provision/edited";
    }
}
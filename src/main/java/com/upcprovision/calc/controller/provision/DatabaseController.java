package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.CustomUserDetails;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.repos.UserRepo;
import com.upcprovision.calc.services.ConvertService;
import com.upcprovision.calc.services.DealsServices;
import com.upcprovision.calc.services.TotalSales;
import com.upcprovision.calc.services.UtargCalc;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DatabaseController {

    public DatabaseController(UtargCalc utargCalc, TotalSales totalSales, DealsServices dealsServices, ConvertService convertService, UserRepo userRepo) {
        this.utargCalc = utargCalc;
        this.totalSales = totalSales;
        this.dealsServices = dealsServices;
        this.convertService = convertService;
        this.userRepo = userRepo;
    }

    private UserRepo userRepo;
    private UtargCalc utargCalc;
    private TotalSales totalSales;
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
        dealsServices.add(convertService.convert(deal, utargCalc));
        session.setAttribute("list", dealsServices.getByLog(getUsername()));
        session.setAttribute("numerlog", getUsername());
        session.setAttribute("total", totalSales.getTotalSales(totalSales.findAllByLog(getUsername())));
        return "redirect:/app/getDealsdone";
  }


    @GetMapping("/app/getdeals")
    public String getDeals(HttpSession session) {
        session.setAttribute("list", dealsServices.getByLog(getUsername()));
        session.setAttribute("numerlog", getUsername());
        session.setAttribute("total", totalSales.getTotalSales(totalSales.findAllByLog(getUsername())));
        return "redirect:/app/getDealsdone";
    }

    @GetMapping("/app/getDealsdone")
    public String getDealsDoneProcess() {
        return "redirect:/app/dealslist";
    }


    @GetMapping("/app/dealslist")
    public String getDealsDone() {
        return "getDealsdone";
    }
}

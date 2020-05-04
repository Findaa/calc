package com.upcprovision.calc.controller.provision;


import com.upcprovision.calc.services.provision.LeaderService;
import com.upcprovision.calc.security.user.CustomUserDetails;
import com.upcprovision.calc.services.UserService;
import com.upcprovision.calc.services.provision.DealsServices;
import com.upcprovision.calc.services.provision.ProvisionCalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LeaderController {

    @Autowired
    public LeaderController(ProvisionCalculatorServices provisionCalculatorServices, DealsServices dealsServices, LeaderService leaderService, UserService userService) {
        this.provisionCalculatorServices = provisionCalculatorServices;
        this.dealsServices = dealsServices;
        this.leaderService = leaderService;
        this.userService = userService;
    }

    private LeaderService leaderService;
    private ProvisionCalculatorServices provisionCalculatorServices;
    private DealsServices dealsServices;
    private UserService userService;

    public int getLeaderId() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getLeaderid();
    }

    @GetMapping("/leader/app")
    public String viewLeaderapp() {
        return "/leader/app";
    }

    @GetMapping("/leader/getdatabase")
    public String viewDatabaseCheckout(Model model) {
        model.addAttribute("id", new String());
        return "leader/getDatabase";
    }

    @PostMapping("/processDb")
    public String databaseProcess(@ModelAttribute("id") String log, HttpSession session) {
        session.setAttribute("list", dealsServices.getByLog(log));
        session.setAttribute("numerlog", log);
        session.setAttribute("total", provisionCalculatorServices.getTotalSales(provisionCalculatorServices.findAllByLog(log)));
        return "redirect:/leader/getdealsdone";
    }

    @GetMapping("/leader/getdealsdone")
    public String getDealsDone() {
        return "/leader/getdealsdone";
    }

    @PostMapping("/leader/getteam")
    public String viewTeam(HttpSession session){
        int id = 1;
        session.setAttribute("list", leaderService.getTeamDeals(id));
        session.setAttribute("numerlog", id);
        session.setAttribute("total", provisionCalculatorServices.getTotalSales(leaderService.getTeamDeals(id)));
        return "redirect:/leader/teamresult";
    }

    @GetMapping("/leader/teamresult")
    public String viewTeamSales(){
        return "/leader/teamresult";
    }


}



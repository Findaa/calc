package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.model.CustomUserDetails;
import com.upcprovision.calc.repos.UserService;
import com.upcprovision.calc.services.DealsServices;
import com.upcprovision.calc.services.LeaderService;
import com.upcprovision.calc.services.TotalSales;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LeaderController {


    public LeaderController(TotalSales totalSales, DealsServices dealsServices, LeaderService leaderService, UserService userService) {
        this.totalSales = totalSales;
        this.dealsServices = dealsServices;
        this.leaderService = leaderService;
        this.userService = userService;
    }
    private LeaderService leaderService;
    private TotalSales totalSales;
    private DealsServices dealsServices;
    private UserService userService;

    public int getLeaderId() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getLeaderid();

    }



    @GetMapping("/leader/app")
    public String viewLeaderapp() {
        return "leader/app";
    }

    @GetMapping("/leader/getDatabase")
    public String viewDatabaseCheckout(Model model) {
        model.addAttribute("id", new String());
        return "leader/getDatabase";
    }

    @PostMapping("/processDb")
    public String databaseProcess(@ModelAttribute("id") String log, HttpSession session) {
        System.out.println(log+": stringLeaderUsername");
        session.setAttribute("list", dealsServices.getByLog(log));
        session.setAttribute("numerlog", log);
        session.setAttribute("total", totalSales.getTotalSales(totalSales.findAllByLog(log)));
        return "redirect:/leader/getDealsdone";
    }

    @GetMapping("/leader/getDealsdone")
    public String getDealsDone() {
        return "leader/getDealsdone";
    }

    @PostMapping("/leader/getteam")
    public String viewTeam(HttpSession session){
        int id = 1;
        System.out.println("! Postmapping /leader/getteam !");
        System.out.println("userService.listAllByLeader: " + userService.findAllByLeaderid(id));
        session.setAttribute("list", leaderService.getTeamDeals(id));
        session.setAttribute("numerlog", id);
        session.setAttribute("total", totalSales.getTotalSales(leaderService.getTeamDeals(id)));
        return "redirect:/leader/teamresult";
    }

    @GetMapping("/leader/teamresult")
    public String viewTeamSales(){
        return "leader/teamresult";
    }


}



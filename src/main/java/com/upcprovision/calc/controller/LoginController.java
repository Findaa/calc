package com.upcprovision.calc.controller;


import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    @RequestMapping("login")
    public String viewLogin(Model model) {
        return "login";
    }

    @GetMapping("/app")
    public String viewApp() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getAuthorities().toString()+": Logged on authority");
        return "app";
    }

    @RequestMapping("/app/logout")
    public String viewLogout(HttpServletRequest r, HttpServletResponse a) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(r, a, auth);
        }
        return "redirect:/index";
    }

    @RequestMapping("/leader/logout")
    public String viewLeaderLogout(HttpServletRequest r, HttpServletResponse a) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(r, a, auth);
        }
        return "redirect:/index";
    }


    @RequestMapping("/logout")
   public String viewLogoutWrong() {return "redirect:/app/logout";}

    @GetMapping("/login?logout")
    public String viewLogout(){
        return "redirect:/index";
    }
}

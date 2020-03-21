package com.upcprovision.calc.controller.auth;


import lombok.Getter;
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

    @RequestMapping("/app/logout")
    public String viewLogout(HttpServletRequest rq, HttpServletResponse re) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(rq, re, auth);
        }
        return "redirect:/index";
    }

    @RequestMapping("/login")
    public String viewLogin() { return "login"; }

    @GetMapping("/app")
    public String viewApp() { return "provision/app"; }

    @RequestMapping("/leader/logout")
    public String viewLeaderLogout(HttpServletRequest rq, HttpServletResponse re) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(rq, re, auth);
        }
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String viewLogoutWrong() {return "redirect:/app/logout";}

    @GetMapping("/login?logout")
    public String viewLogout(){
        return "redirect:/index";
    }

    @GetMapping("/oauthLogin")
    public String fbLogin()
    {
        return "fblogin";
    }
}

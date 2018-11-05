package com.upcprovision.calc.controller;


import com.upcprovision.calc.model.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {


    @GetMapping("/index")
    public String viewIndex() {
        return "index";
    }


    @GetMapping("/")
    public String viewIndexFromMain() {
        return "index";
    }


    @GetMapping("/error")
    public String viewError() {
        return "error";
    }

    @GetMapping("/403")
    public String view403() {
        return "403";
    }

}

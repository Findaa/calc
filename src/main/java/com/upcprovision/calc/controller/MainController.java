package com.upcprovision.calc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String viewIndex() { return "/index"; }

    @GetMapping("/")
    public String viewIndexFromMain() { return "/index"; }

    @GetMapping("/error")
    public String viewError() { return "/error"; }

    @GetMapping("/403")
    public String view403() { return "/403"; }

    @GetMapping("/provisionapp")
    public String getProvApp(){
        return "provision/provapp";
    }
}

package com.upcprovision.calc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/index")
    public String viewIndex() { return "index"; }

    @GetMapping("/")
    public String viewIndexFromMain() { return "index"; }

    @GetMapping("/error")
    public String viewError() { return "error"; }

    @GetMapping("/403")
    public String view403() { return "403"; }

    @GetMapping("/provisionapp")
    public String getProvApp(){
        return "provision/provapp";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }
}
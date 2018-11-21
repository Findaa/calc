package com.upcprovision.calc.controller;

import com.upcprovision.calc.security.CustomUserDetails;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.provision.DealsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RestControllerr {


    @Autowired
    DealsServices dealsServices;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();

    }

    @GetMapping("/getDealsData")
    @ResponseBody
    public List<Deals> getDealsData() {
        return dealsServices.findAll();
    }

    @GetMapping("/getUserDeals")
    @ResponseBody
    public List<Deals> getUserDeals() {
        return dealsServices.getByLog(getUsername());
    }


    @GetMapping("/dupa")
    @ResponseBody
    public double getResult(@RequestParam(value = "lol") double lol, @RequestParam(value = "total") double total,
                            @RequestParam(value = "dupa") double dupa, @RequestParam(value = "dupa2") double dupa2) {
        return total - lol - dupa - dupa2;
    }

}

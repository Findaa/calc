package com.upcprovision.calc.controller;

import com.upcprovision.calc.security.user.CustomUserDetails;
import com.upcprovision.calc.security.user.Role;
import com.upcprovision.calc.services.provision.DealsServices;
import com.upcprovision.calc.services.provision.ProvisionCalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Service
public class ControllerServices {
    @Autowired
    public ControllerServices(ProvisionCalculatorServices provisionCalculatorServices, DealsServices dealsServices) {
        this.provisionCalculatorServices = provisionCalculatorServices;
        this.dealsServices = dealsServices;
    }

    private ProvisionCalculatorServices provisionCalculatorServices;
    private DealsServices dealsServices;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    public String setDealsAttribute(HttpSession session) {
        session.setAttribute("list", dealsServices.getByLog(getUsername()));
        session.setAttribute("numerlog", getUsername());
        session.setAttribute("total", provisionCalculatorServices.getTotalSales(provisionCalculatorServices.findAllByLog(getUsername())));
        return "redirect:/app/getdealsdone";
    }

    public Set<Role> getUserAuth() {
        Set<Role> auth = new HashSet<>();
        auth.add(new Role("USER"));
        return auth;
    }
}

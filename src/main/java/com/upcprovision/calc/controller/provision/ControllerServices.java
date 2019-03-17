package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.security.CustomUserDetails;
import com.upcprovision.calc.security.Role;
import com.upcprovision.calc.services.provision.DealsServices;
import com.upcprovision.calc.services.provision.ProvisionTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Service
public class ControllerServices {

    @Autowired
    public ControllerServices(ProvisionTotal provisionTotal, DealsServices dealsServices) {
        this.provisionTotal = provisionTotal;
        this.dealsServices = dealsServices;
    }

    private ProvisionTotal provisionTotal;
    private DealsServices dealsServices;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    String setDealsAttribute(HttpSession session){
        session.setAttribute("list", dealsServices.getByLog(getUsername()));
        session.setAttribute("numerlog", getUsername());
        session.setAttribute("total", provisionTotal.getTotalSales(provisionTotal.findAllByLog(getUsername())));
        return "redirect:/app/getdealsdone";
    }


    public Set<Role> getUserAuth() {
        Set<Role> auth = new HashSet<>();
        auth.add(new Role("USER"));
        return auth;
    }
}

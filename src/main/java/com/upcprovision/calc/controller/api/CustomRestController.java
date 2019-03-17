package com.upcprovision.calc.controller.api;

import com.upcprovision.calc.model.provision.Target;
import com.upcprovision.calc.security.CustomUserDetails;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.provision.DealsServices;
import com.upcprovision.calc.services.provision.ProvisionFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomRestController {

    private DealsServices dealsServices;
    private ProvisionFinal provisionFinal;

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    @Autowired
    public CustomRestController(DealsServices dealsServices, ProvisionFinal provisionFinal) {
        this.dealsServices = dealsServices;
        this.provisionFinal = provisionFinal;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getDealsData")
    @ResponseBody
    public List<Deals> getDealsData() {
        return dealsServices.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUserDeals")
    @ResponseBody
    public List<Deals> getUserDeals() {
        return dealsServices.getByLog(getUsername());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/dupa")
    @ResponseBody
    public String getResult(@RequestParam(value = "premium") int premium,
                            @RequestParam(value = "fcr") int fcr,
                            @RequestParam(value = "nps") int nps,
                            @RequestParam(value = "upgradex") int upgradex,
                            @RequestParam(value = "cpremium") int cpremium,
                            @RequestParam(value = "cfcr") int cfcr,
                            @RequestParam(value = "cnps") int cnps,
                            @RequestParam(value = "cupgrade") int cupgrade,
                            @RequestParam(value = "arpu") int arpu) {
        System.out.println("Website is: ");
        Target target = new Target(fcr, cfcr, nps, cnps, upgradex, cupgrade, premium, cpremium, arpu);

        return Double.toString(provisionFinal.calc(0, target));
    }

}

package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.provision.DealsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvisionTotal {

    private DealsServices dealsRepo;

    @Autowired
    public ProvisionTotal(DealsServices dealsRepo) {
        this.dealsRepo = dealsRepo;
    }

    public List<Deals> findAllByLog(String log) {
        return dealsRepo.findAllByLog(log);
    }

    public double getTotalSales(List<Deals> deals) {
        int g = deals.size();
        double total = 0;
        for (Deals deal : deals) {
            total += deal.getUtarg();
        }
        return total;
    }
}



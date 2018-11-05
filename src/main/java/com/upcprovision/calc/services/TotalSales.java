package com.upcprovision.calc.services;

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.repos.provision.DealsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalSales {

    @Autowired
    DealsServices dealsRepo;

    public TotalSales(DealsServices dealsRepo) {
        this.dealsRepo = dealsRepo;
    }

    public List<Deals> findAllByLog(String log) {
        System.out.println();
        return dealsRepo.findAllByLog(log);
    }

    public double getTotalSales(List<Deals> deals) {
        int g = deals.size();
        double total = 0;
        for (int i = 0; i < g; i++) {
            total += deals.get(i).getUtarg();
        }

        return total;
    }


}



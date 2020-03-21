
package com.upcprovision.calc.services.implementations;

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.repos.DealsRepo;
import com.upcprovision.calc.services.provision.DealsServices;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DealsServicesImpl implements DealsServices {
    public DealsServicesImpl(DealsRepo dealsRepo) {
        this.dealsRepo = dealsRepo;
    }

    private DealsRepo dealsRepo;

    @Override
    public List<Deals> findImputed() {
        List<Deals> result = dealsRepo.findAll();

        result.forEach(deal -> {
            if (deal.getLojCash() == 0) deal.setLojCash(0);
            if (deal.getSegCash() == 0) deal.setSegCash(0);
            if (deal.getSegment() == 0) deal.setSegment(0);
            if (deal.getRecCash() == 0) deal.setRecCash(0);
            if (deal.getMscCash() == 0) deal.setMscCash(110);
        });
        return result;
    }

    @Override
    public List<Deals> getByLog(String log) {
        return dealsRepo.findAllByLog(log);
    }

    @Override
    public void add(Deals deals) {
        dealsRepo.save(deals);
    }

    @Override
    public Deals findAllById(Long id) {
        return dealsRepo.findAllById(id);
    }

    @Override
    public void deleteById(Long id) {
        dealsRepo.deleteById(id);
    }

    @Override
    public List<Deals> findAllByLog(String log) {
        return dealsRepo.findAllByLog(log);
    }

    @Override
    public List<Deals> findAll() {
        return dealsRepo.findAll();
    }
}
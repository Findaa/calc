
package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.repos.provision.DealsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealsServices{

    private DealsRepo dealsRepo;

    public DealsServices(DealsRepo dealsRepo) {
        this.dealsRepo = dealsRepo;
    }
    public List<Deals> getByLog(String log) {
        return dealsRepo.findAllByLog(log);
    }
    public void add(Deals deals) {
        dealsRepo.save(deals);
    }
    public Deals findAllById(Long id){return dealsRepo.findAllById(id);}
    public void deleteById(Long id){dealsRepo.deleteById(id);}
    public List<Deals> findAllByLog(String log){return dealsRepo.findAllByLog(log);}
    public List<Deals> findAll(){return dealsRepo.findAll();}
}
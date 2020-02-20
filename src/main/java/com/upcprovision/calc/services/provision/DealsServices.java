
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
    public List<Deals> findImputed(){
        List<Deals> result = dealsRepo.findAll();

        result.forEach(deal ->{
            if(deal.getLojCash() == 0) deal.setLojCash(0);
            if(deal.getSegCash() == 0) deal.setSegCash(0);
            if(deal.getSegment() == 0) deal.setSegment(0);
            if(deal.getRecCash() == 0) deal.setRecCash(0);
            if(deal.getmscCash() == 0) deal.setmscCash(110);

        });

        return result;


    }
}
package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.model.provision.Deals;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DealsServices {
    List<Deals> findImputed();
    List<Deals> getByLog(String log);
    void add(Deals deals);
    Deals findAllById(Long id);
    void deleteById(Long id);
    List<Deals> findAllByLog(String log);
    List<Deals> findAll();
}

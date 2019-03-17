package com.upcprovision.calc.repos.provision;

import com.upcprovision.calc.model.provision.Deals;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeaderService {
    int getLeader(String leader);
    List<Deals> getTeamDeals(int id) ;
}

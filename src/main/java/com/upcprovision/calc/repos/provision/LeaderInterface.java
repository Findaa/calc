package com.upcprovision.calc.repos.provision;

import com.upcprovision.calc.model.provision.Deals;

import java.util.List;

public interface LeaderInterface {
    int getLeader(String leader);
    List<Deals> getTeamDeals(int id) ;
}

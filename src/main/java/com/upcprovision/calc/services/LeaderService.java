package com.upcprovision.calc.services;

import com.upcprovision.calc.model.CustomUserDetails;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.provision.LeaderInterface;
import com.upcprovision.calc.repos.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderService implements LeaderInterface {


    @Autowired
    UserService userService;

    @Autowired
    DealsServices dealsServices;


    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    @Override
    public int getLeader(String leader) {
        int leaderid;
        String leader1 = "leader1";
        String leader2 = "leader2";

        if (leader.equals(leader1)) {
            leaderid = 1;
        } else if (leader.equals(leader2)) {
            leaderid = 2;
        } else {
            leaderid = 3;
        }
        return leaderid;
    }

    @Override
    public List<Deals> getTeamDeals(int id) throws NullPointerException {
        List<Deals> tempDeals = new ArrayList<>();
        List<User> usera = userService.listAll();
        List<User> user = new ArrayList<>();

        for (int i = 0; i < usera.size(); i++) {
            if (usera.get(i).getLeaderid() == id) {
                user.add(usera.get(i));
            } else {
            }
        }
        int size = user.size();

        for (int i = 0; i < size; i++) {
            tempDeals.addAll(dealsServices.getByLog(user.get(i).getUsername()));
        }
        return tempDeals;
    }
}

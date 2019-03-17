package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.security.CustomUserDetails;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderServiceImpl implements com.upcprovision.calc.repos.provision.LeaderService {

    private UserService userService;
    private DealsServices dealsServices;

    @Autowired
    public LeaderServiceImpl(UserService userService, DealsServices dealsServices) {
        this.userService = userService;
        this.dealsServices = dealsServices;
    }

    public String getUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    @Override
    public int getLeader(String leader) {
        int leaderid;
        String leader1 = "leader1";
        String leader2 = "leader2";

        System.out.println(leader+": leaderVarToMethod");

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
        List<User> userList = userService.listAll();
        List<User> user = new ArrayList<>();

        for (User single : userList) {
            if (single.getLeaderid() == id) {
                user.add(single);
            }
        }

        for (User single : user) {
            tempDeals.addAll(dealsServices.getByLog(single.getUsername()));
        }
        return tempDeals;
    }
}

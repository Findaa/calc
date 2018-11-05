package com.upcprovision.calc.model.provision;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Leader {

    @Id
    private int leaderid;
    private String username;

    public int getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(int leaderid) {
        this.leaderid = leaderid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}

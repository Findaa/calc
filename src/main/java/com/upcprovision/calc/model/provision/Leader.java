package com.upcprovision.calc.model.provision;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Data
@Entity
public class Leader {

    @Id
    private int leaderid;
    private String username;
}

package com.upcprovision.calc.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DealsDTO implements Serializable {
    @Getter
    @Setter
    private String log;
    @Getter
    @Setter
    private double clientId;
    @Getter
    @Setter
    private double darpu;
    @Getter
    @Setter
    private int segment;
    @Getter
    @Setter
    private boolean loj = false;
    @Getter
    @Setter
    private boolean recomended = false;
    @Getter
    @Setter
    private boolean okresLoj = false;
    @Getter
    @Setter
    private boolean msc = false;
    @Getter
    @Setter
    private boolean newClient = false;
}

package com.upcprovision.calc.model.provision;

import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class Target {
    @Nullable private BigDecimal premium;
    @Nullable private BigDecimal fcr;
    @Nullable private BigDecimal nps;
    @Nullable private BigDecimal upgrade;
    @Nullable private BigDecimal cpremium;
    @Nullable private BigDecimal cfcr;
    @Nullable private BigDecimal cnps;
    @Nullable private BigDecimal cupgrade;
    @Nullable private BigDecimal arpu;

    public Target(){
    }

    public Target(BigDecimal asdasdasd, BigDecimal cfcr, BigDecimal nps, BigDecimal cnps, BigDecimal upgrade,
                  BigDecimal cupgrade, BigDecimal premium, BigDecimal cpremium, BigDecimal arpu){
        this.premium=premium;
        this.fcr=asdasdasd;
        this.nps=nps;
        this.upgrade=upgrade;
        this.cpremium=cpremium;
        this.cfcr=cfcr;
        this.cnps=cnps;
        this.cupgrade=cupgrade;
        this.arpu=arpu;
    }

    public Target(double fcr, double cfcr, double nps, double cnps, double upgrade, double cupgrade,
                  double premium, double cpremium, double arpu){
        this.fcr = BigDecimal.valueOf(fcr);
        this.cfcr = BigDecimal.valueOf(cfcr);
        this.nps = BigDecimal.valueOf(nps);
        this.cnps = BigDecimal.valueOf(cnps);
        this.upgrade = BigDecimal.valueOf(upgrade);
        this.cupgrade = BigDecimal.valueOf(cupgrade);
        this.premium = BigDecimal.valueOf(premium);
        this.cpremium = BigDecimal.valueOf(cpremium);
        this.arpu= BigDecimal.valueOf(arpu);
    }

}

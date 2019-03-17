package com.upcprovision.calc.model.provision;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
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
    public Target(BigDecimal asdasdasd, BigDecimal cfcr, BigDecimal nps, BigDecimal cnps, BigDecimal upgrade, BigDecimal cupgrade, BigDecimal premium, BigDecimal cpremium, BigDecimal arpu){
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

    @Nullable
    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(@Nullable BigDecimal premium) {
        this.premium = premium;
    }

    @Nullable
    public BigDecimal getFcr() {
        return fcr;
    }

    public void setFcr(@Nullable BigDecimal fcr) {
        this.fcr = fcr;
    }

    @Nullable
    public BigDecimal getNps() {
        return nps;
    }

    public void setNps(@Nullable BigDecimal nps) {
        this.nps = nps;
    }

    @Nullable
    public BigDecimal getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(@Nullable BigDecimal upgrade) {
        this.upgrade = upgrade;
    }

    @Nullable
    public BigDecimal getCpremium() {
        return cpremium;
    }

    public void setCpremium(@Nullable BigDecimal cpremium) {
        this.cpremium = cpremium;
    }

    @Nullable
    public BigDecimal getCfcr() {
        return cfcr;
    }

    public void setCfcr(@Nullable BigDecimal cfcr) {
        this.cfcr = cfcr;
    }

    @Nullable
    public BigDecimal getCnps() {
        return cnps;
    }

    public void setCnps(@Nullable BigDecimal cnps) {
        this.cnps = cnps;
    }

    @Nullable
    public BigDecimal getCupgrade() {
        return cupgrade;
    }

    public void setCupgrade(@Nullable BigDecimal cupgrade) {
        this.cupgrade = cupgrade;
    }

    @Nullable
    public BigDecimal getArpu() {
        return arpu;
    }

    public void setArpu(@Nullable BigDecimal arpu) {
        this.arpu = arpu;
    }
}

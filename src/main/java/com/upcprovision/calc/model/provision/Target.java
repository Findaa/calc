/** done*/


package com.upcprovision.calc.model.provision;

import java.math.BigDecimal;

public class Target {
    private BigDecimal premium;
    private BigDecimal fcr;
    private BigDecimal nps;
    private BigDecimal upgrade;
    private BigDecimal cpremium;
    private BigDecimal cfcr;
    private BigDecimal cnps;
    private BigDecimal cupgrade;
    private BigDecimal arpu;

    public Target(){
    }
    public Target(BigDecimal fcr, BigDecimal cfcr, BigDecimal nps, BigDecimal cnps, BigDecimal upgrade, BigDecimal cupgrade, BigDecimal premium, BigDecimal cpremium, BigDecimal arpu){
        this.premium=premium;
        this.fcr=fcr;
        this.nps=nps;
        this.upgrade=upgrade;
        this.cpremium=cpremium;
        this.cfcr=cfcr;
        this.cnps=cnps;
        this.cupgrade=cupgrade;
        this.arpu=arpu;
    }

    public BigDecimal getArpu() {return arpu; }
    public void setArpu(BigDecimal arpu) {this.arpu = arpu;}
    public BigDecimal getPremium() {
        return premium;
    }
    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }
    public BigDecimal getFcr() {
        return fcr;
    }
    public void setFcr(BigDecimal fcr) {
        this.fcr = fcr;
    }
    public BigDecimal getNps() {
        return nps;
    }
    public void setNps(BigDecimal nps) {
        this.nps = nps;
    }
    public BigDecimal getUpgrade() {
        return upgrade;
    }
    public void setUpgrade(BigDecimal upgrade) {this.upgrade = upgrade;}
    public BigDecimal getCpremium() {
        return cpremium;
    }
    public void setCpremium(BigDecimal cpremium) {
        this.cpremium = cpremium;
    }
    public BigDecimal getCfcr() {
        return cfcr;
    }
    public void setCfcr(BigDecimal cfcr) {
        this.cfcr = cfcr;
    }
    public BigDecimal getCnps() {
        return cnps;
    }
    public void setCnps(BigDecimal cnps) {this.cnps = cnps;}
    public BigDecimal getCupgrade() {
        return cupgrade;
    }
    public void setCupgrade(BigDecimal cupgrade) {
        this.cupgrade = cupgrade;
    }
}

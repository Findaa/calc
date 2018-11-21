package com.upcprovision.calc.dto;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class DealsDTO implements Serializable {
   private String log;
   private double clientid;
   private double darpu;
   private int segment;
   private boolean loj = false;
   private boolean recomended = false;
   private boolean okresloj=false;
   private boolean msc=false;
   private boolean newclient=false;


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public double getClientid() {
        return clientid;
    }

    public void setClientid(double clientid) {
        this.clientid = clientid;
    }

    public double getDarpu() {
        return darpu;
    }

    public void setDarpu(double darpu) {
        this.darpu = darpu;
    }

    public boolean isLoj() {
        return loj;
    }

    public void setLoj(boolean loj) {
        this.loj = loj;
    }

    public boolean isRecomended() {
        return recomended;
    }

    public void setRecomended(boolean recomended) {
        this.recomended = recomended;
    }

    public boolean isOkresloj() {
        return okresloj;
    }

    public void setOkresloj(boolean okresloj) {
        this.okresloj = okresloj;
    }

    public boolean isMsc() {
        return msc;
    }

    public void setMsc(boolean msc) {
        this.msc = msc;
    }

    public int getSegment() {
        return segment;
    }

    public void setSegment(int segment) {
        this.segment = segment;
    }

    public boolean isNewclient() {
        return newclient;
    }

    public void setNewclient(boolean newclient) {
        this.newclient = newclient;
    }
}

package com.upcprovision.calc.dto;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class DealsDTO implements Serializable {
   private String log;
   private double clientId;
   private double darpu;
   private int segment;
   private boolean loj = false;
   private boolean recomended = false;
   private boolean okresLoj=false;
   private boolean msc=false;
   private boolean newClient=false;


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public double getClientId() {
        return clientId;
    }

    public void setClientId(double clientId) {
        this.clientId = clientId;
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
        return okresLoj;
    }

    public void setOkresloj(boolean okresLoj) {
        this.okresLoj = okresLoj;
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

    public boolean isnewClient() {
        return newClient;
    }

    public void setnewClient(boolean newClient) {
        this.newClient = newClient;
    }
}

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
   private boolean canalupgr=false;
   private boolean hboupgr=false;
   private boolean dtvupgr=false;
   private boolean inteupgr=false;
   private boolean telupgr=false;
   private boolean cinemax=false;
   private boolean filmbox=false;
   private boolean filmklub=false;
   private boolean canal=false;
   private boolean hbo=false;
   private boolean dtv=false;
   private boolean inte=false;
   private boolean tel=false;
   private boolean hzn=false;
   private boolean extra=false;
   private boolean myprime=false;
   private boolean megasport=false;
   private boolean psp=false;




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

    public boolean isCanalupgr() {
        return canalupgr;
    }

    public void setCanalupgr(boolean canalupgr) {
        this.canalupgr = canalupgr;
    }

    public boolean isHboupgr() {
        return hboupgr;
    }

    public void setHboupgr(boolean hboupgr) {
        this.hboupgr = hboupgr;
    }

    public boolean isDtvupgr() {
        return dtvupgr;
    }

    public void setDtvupgr(boolean dtvupgr) {
        this.dtvupgr = dtvupgr;
    }

    public boolean isInteupgr() {
        return inteupgr;
    }

    public void setInteupgr(boolean inteupgr) {
        this.inteupgr = inteupgr;
    }

    public boolean isTelupgr() {
        return telupgr;
    }

    public void setTelupgr(boolean telupgr) {
        this.telupgr = telupgr;
    }

    public boolean isCinemax() {
        return cinemax;
    }

    public void setCinemax(boolean cinemax) {
        this.cinemax = cinemax;
    }

    public boolean isFilmbox() {
        return filmbox;
    }

    public void setFilmbox(boolean filmbox) {
        this.filmbox = filmbox;
    }

    public boolean isFilmklub() {
        return filmklub;
    }

    public void setFilmklub(boolean filmklub) {
        this.filmklub = filmklub;
    }

    public boolean isCanal() {
        return canal;
    }

    public void setCanal(boolean canal) {
        this.canal = canal;
    }

    public boolean isHbo() {
        return hbo;
    }

    public void setHbo(boolean hbo) {
        this.hbo = hbo;
    }

    public boolean isDtv() {
        return dtv;
    }

    public void setDtv(boolean dtv) {
        this.dtv = dtv;
    }

    public boolean isInte() {
        return inte;
    }

    public void setInte(boolean inte) {
        this.inte = inte;
    }

    public boolean isTel() {
        return tel;
    }

    public void setTel(boolean tel) {
        this.tel = tel;
    }

    public boolean isHzn() {
        return hzn;
    }

    public void setHzn(boolean hzn) {
        this.hzn = hzn;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public boolean isMyprime() {
        return myprime;
    }

    public void setMyprime(boolean myprime) {
        this.myprime = myprime;
    }

    public boolean isMegasport() {
        return megasport;
    }

    public void setMegasport(boolean megasport) {
        this.megasport = megasport;
    }

    public boolean isPsp() {
        return psp;
    }

    public void setPsp(boolean psp) {
        this.psp = psp;
    }
}

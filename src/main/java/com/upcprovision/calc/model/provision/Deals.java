package com.upcprovision.calc.model.provision;
import com.upcprovision.calc.dto.DealsDTO;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
@Entity
@Table(name="deals")
public class Deals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String log;
    private double clientid;
    private double darpu;
    private int segment;
    private boolean loj = false;
    private boolean recomended = false;
    private boolean okresloj=false;
    private boolean msc=false;
    private double utarg;
    private double lojcash;
    private double reccash;
    private double msccash;
    private double segcash;
    private boolean newclient=false;


    private boolean canalupgr;
    private boolean hboupgr;
    private boolean dtvupgr;
    private boolean inteupgr;
    private boolean telupgr;
    private boolean cinemax;
    private boolean filmbox;
    private boolean filmklub;
    private boolean canal;
    private boolean hbo;
    private boolean dtv;
    private boolean inte;
    private boolean tel;
    private boolean hzn;
    private boolean extra;
    private boolean myprime;
    private boolean megasport;
    private boolean psp;




    public Deals(Long id, DealsDTO dealsDTO){
        this.id = id;
        this.log = dealsDTO.getLog();
        this.clientid = dealsDTO.getClientid();
        this.darpu = dealsDTO.getDarpu();
        this.segment = dealsDTO.getSegment();
        this.loj = dealsDTO.isLoj();
        this.recomended = dealsDTO.isRecomended();
        this.okresloj =dealsDTO.isOkresloj();
        this.msc = dealsDTO.isMsc();
    }

    public Deals(String log, double clientid, double darpu, int segment, boolean loj, boolean recomended, boolean okresloj,
                 boolean msc, double utarg, double lojcash, double reccash, double msccash, double segcash, boolean newclient,
                 boolean canalupgr, boolean hboupgr, boolean dtvupgr, boolean inteupgr, boolean telupgr,
                 boolean cinemax, boolean filmbox, boolean filmklub, boolean canal, boolean hbo, boolean dtv, boolean inte,
                 boolean tel, boolean hzn, boolean extra, boolean myprime, boolean megasport, boolean psp) {
        this.log = log;
        this.clientid = clientid;
        this.darpu = darpu;
        this.segment = segment;
        this.loj = loj;
        this.recomended = recomended;
        this.okresloj = okresloj;
        this.msc = msc;
        this.utarg = utarg;
        this.lojcash = lojcash;
        this.reccash = reccash;
        this.msccash = msccash;
        this.segcash = segcash;
        this.newclient = newclient;
        this.canalupgr = canalupgr;
        this.hboupgr = hboupgr;
        this.dtvupgr = dtvupgr;
        this.inteupgr = inteupgr;
        this.telupgr = telupgr;
        this.cinemax = cinemax;
        this.filmbox = filmbox;
        this.filmklub = filmklub;
        this.canal = canal;
        this.hbo = hbo;
        this.dtv = dtv;
        this.inte = inte;
        this.tel = tel;
        this.hzn = hzn;
        this.extra = extra;
        this.myprime = myprime;
        this.megasport = megasport;
        this.psp = psp;
    }

    public Deals(Long id, String log, double clientid, double darpu, int segment, boolean loj, boolean recomended, boolean okresloj, boolean msc, double utarg, double lojcash, double reccash, double msccash, double segcash) {
        this.id = id;
        this.log = log;
        this.clientid = clientid;
        this.darpu = darpu;
        this.segment = segment;
        this.loj = loj;
        this.recomended = recomended;
        this.okresloj = okresloj;
        this.msc = msc;
        this.utarg = utarg;
        this.lojcash = lojcash;
        this.reccash = reccash;
        this.msccash = msccash;
        this.segcash = segcash;
    }


    public Deals(String log, double clientid, double darpu, int segment, boolean loj, boolean recomended, boolean okresloj, boolean msc, double utarg) {
        this.log = log;
        this.clientid = clientid;
        this.darpu = darpu;
        this.loj = loj;
        this.recomended = recomended;
        this.okresloj = okresloj;
        this.msc = msc;
        this.segment = segment;
        this.utarg=utarg;
    }

    public Deals(String log, double clientid, double darpu, int segment, boolean loj,  boolean recomended, boolean okresloj, boolean msc) {
        this.log = log;
        this.clientid = clientid;
        this.darpu = darpu;
        this.loj = loj;
        this.recomended = recomended;
        this.okresloj = okresloj;
        this.msc = msc;
        this.segment = segment;
    }



    public Deals(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public double getUtarg() {
        return utarg;
    }

    public void setUtarg(double utarg) {
        this.utarg = utarg;
    }

    public double getLojcash() {return lojcash;}

    public void setLojcash(double lojcash) {this.lojcash = lojcash;}

    public double getReccash() {return reccash;}

    public void setReccash(double reccash) {this.reccash = reccash;}

    public double getMsccash() {return msccash;}

    public void setMsccash(double msccash) {this.msccash = msccash;}

    public double getSegcash() {
        return segcash;
    }

    public void setSegcash(double segcash) {
        this.segcash = segcash;
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

    @Override
    public String toString() {
        return "Deals{" + "id=" + id + ", log='" + log + '\'' + ", clientid=" + clientid + ", darpu=" + darpu + ", segment=" + segment + ", loj=" + loj + ", recomended=" + recomended + ", okresloj=" + okresloj + ", msc=" + msc + ", utarg=" + utarg + '}';
    }


}



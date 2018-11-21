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
                 boolean msc, double utarg, double lojcash, double reccash, double msccash, double segcash, boolean newclient) {
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
}



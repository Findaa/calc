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
   private double clientId;
   private double darpu;
   private int segment;
   private boolean loj = false;
   private boolean recomended = false;
   private boolean okresLoj=false;
   private boolean msc=false;
   private double utarg;
   private double lojCash;
   private double recCash;
   private double mscCash;
   private double segCash;
   private boolean newClient=false;


    public Deals(Long id, DealsDTO dealsDTO){
        this.id = id;
        this.log = dealsDTO.getLog();
        this.clientId = dealsDTO.getClientId();
        this.darpu = dealsDTO.getDarpu();
        this.segment = dealsDTO.getSegment();
        this.loj = dealsDTO.isLoj();
        this.recomended = dealsDTO.isRecomended();
        this.okresLoj =dealsDTO.isOkresloj();
        this.msc = dealsDTO.isMsc();
    }

    public Deals(String log, double clientId, double darpu, int segment, boolean loj, boolean recomended, boolean okresLoj,
                 boolean msc, double utarg, double lojCash, double recCash, double mscCash, double segCash, boolean newClient) {
        this.log = log;
        this.clientId = clientId;
        this.darpu = darpu;
        this.segment = segment;
        this.loj = loj;
        this.recomended = recomended;
        this.okresLoj = okresLoj;
        this.msc = msc;
        this.utarg = utarg;
        this.lojCash = lojCash;
        this.recCash = recCash;
        this.mscCash = mscCash;
        this.segCash = segCash;
        this.newClient = newClient;

    }

    public Deals(Long id, String log, double clientId, double darpu, int segment, boolean loj, boolean recomended, boolean okresLoj, boolean msc, double utarg, double lojCash, double recCash, double mscCash, double segCash) {
        this.id = id;
        this.log = log;
        this.clientId = clientId;
        this.darpu = darpu;
        this.segment = segment;
        this.loj = loj;
        this.recomended = recomended;
        this.okresLoj = okresLoj;
        this.msc = msc;
        this.utarg = utarg;
        this.lojCash = lojCash;
        this.recCash = recCash;
        this.mscCash = mscCash;
        this.segCash = segCash;
    }

    public Deals(String log, double clientId, double darpu, int segment, boolean loj, boolean recomended, boolean okresLoj, boolean msc, double utarg) {
        this.log = log;
        this.clientId = clientId;
        this.darpu = darpu;
        this.loj = loj;
        this.recomended = recomended;
        this.okresLoj = okresLoj;
        this.msc = msc;
        this.segment = segment;
        this.utarg=utarg;
    }

    public Deals(String log, double clientId, double darpu, int segment, boolean loj,  boolean recomended, boolean okresLoj, boolean msc) {
        this.log = log;
        this.clientId = clientId;
        this.darpu = darpu;
        this.loj = loj;
        this.recomended = recomended;
        this.okresLoj = okresLoj;
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

    public int getSegment() {
        return segment;
    }

    public void setSegment(int segment) {
        this.segment = segment;
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

    public boolean isOkresLoj() {
        return okresLoj;
    }

    public void setOkresLoj(boolean okresLoj) {
        this.okresLoj = okresLoj;
    }

    public boolean isMsc() {
        return msc;
    }

    public void setMsc(boolean msc) {
        this.msc = msc;
    }

    public double getUtarg() {
        return utarg;
    }

    public void setUtarg(double utarg) {
        this.utarg = utarg;
    }

    public double getLojCash() {
        return lojCash;
    }

    public void setLojCash(double lojCash) {
        this.lojCash = lojCash;
    }

    public double getRecCash() {
        return recCash;
    }

    public void setRecCash(double recCash) {
        this.recCash = recCash;
    }

    public double getmscCash() {
        return mscCash;
    }

    public void setmscCash(double mscCash) {
        this.mscCash = mscCash;
    }

    public double getSegCash() {
        return segCash;
    }

    public void setSegCash(double segCash) {
        this.segCash = segCash;
    }

    public boolean isNewClient() {
        return newClient;
    }

    public void setNewClient(boolean newClient) {
        this.newClient = newClient;
    }
}



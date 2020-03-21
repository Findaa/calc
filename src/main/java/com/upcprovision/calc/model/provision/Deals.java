package com.upcprovision.calc.model.provision;

import com.upcprovision.calc.dto.DealsDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
@Table(name = "deals")
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
    private boolean okresLoj = false;
    private boolean msc = false;
    private double utarg;
    private double lojCash;
    private double recCash;
    private double mscCash;
    private double segCash;
    private boolean newClient = false;

    public Deals(Long id, DealsDTO dealsDTO) {
        this.id = id;
        this.log = dealsDTO.getLog();
        this.clientId = dealsDTO.getClientId();
        this.darpu = dealsDTO.getDarpu();
        this.segment = dealsDTO.getSegment();
        this.loj = dealsDTO.isLoj();
        this.recomended = dealsDTO.isRecomended();
        this.okresLoj = dealsDTO.isOkresloj();
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
        this.utarg = utarg;
    }

    public Deals(String log, double clientId, double darpu, int segment, boolean loj, boolean recomended, boolean okresLoj, boolean msc) {
        this.log = log;
        this.clientId = clientId;
        this.darpu = darpu;
        this.loj = loj;
        this.recomended = recomended;
        this.okresLoj = okresLoj;
        this.msc = msc;
        this.segment = segment;
    }

    public Deals() {
    }
}



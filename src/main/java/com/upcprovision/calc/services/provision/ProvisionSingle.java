package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.dto.DealsDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProvisionSingle {

    double provisionSingleCalc(DealsDTO dealsDTO, int x) {

        BigDecimal p = BigDecimal.valueOf(0);
        BigDecimal d = BigDecimal.valueOf(0);
        BigDecimal i = BigDecimal.valueOf(0);
        double darpu = dealsDTO.getDarpu();
        int segment = dealsDTO.getSegment();
        boolean loj = dealsDTO.isLoj();
        boolean recomended = dealsDTO.isRecomended();
        boolean okresLoj = dealsDTO.isOkresloj();
        boolean msc = dealsDTO.isMsc();
        boolean newClient = dealsDTO.isnewClient();

        if (!loj) {
            p = BigDecimal.valueOf(darpu / 2);
            if(newClient){
                p = p.divide(BigDecimal.valueOf(2));
                System.out.println("Nowy");
            }
        } else {
            boolean flag = true;
            if (darpu > 0 && flag || darpu <= (-10) && flag) {
                p = BigDecimal.valueOf((darpu / 2) + 5.0);
                flag = false;
            }
            if (darpu <= 0 && darpu > -5 && flag) {
                p = BigDecimal.valueOf(darpu / 2 + 7.5);
                flag = false;
            }
            if (darpu <= -5 && darpu > -10 && flag) {
                p = BigDecimal.valueOf(darpu / 2 + 6);
                flag = false;
            }
        }

        if (x == 2) {
            i = p;
        }

        if (okresLoj && loj) {
            d = d.add(p.multiply(BigDecimal.valueOf(0.3)));
        }
        if (recomended) {
            d = d.add(p.multiply(BigDecimal.valueOf(0.2)));
        }
        if (msc) {
            d = d.add(p.multiply(BigDecimal.valueOf(0.2)));
        }

        if (segment == 3) {
            d = d.add(p.multiply(BigDecimal.valueOf(0.1)));
        } else if (segment == 4 || segment == 5) {
            d = d.add(p.multiply(BigDecimal.valueOf(0.15)));
        }

        p = p.add(d);

        if (x == 1) {
            return p.doubleValue();
        } else {
            return i.doubleValue();
        }
}
    double okreslojCash(double darpu, boolean loj, boolean okresLoj) throws NullPointerException {
        double value;
        try {
            if (okresLoj && loj) {
                darpu = darpu * 0.3;
                value = darpu;
            } else {
                value = 0;
            }
        } catch (NullPointerException e) {
            value = 0;
        }
        return value;
    }

    double recCash(double darpu, boolean rec) {

        if (rec) {
            darpu = darpu * 0.2;
            return darpu;
        } else {
            return 0;
        }
    }

    double mscCash(double darpu, boolean msc) {
        if (msc) {
            darpu = darpu * 0.2;
            return darpu;
        } else {
            return 0;
        }
    }

    double segmentcash(double darpu, int seg) {
        if (seg == 3) {
            return darpu * 0.1;
        } else if (seg == 4 || seg == 5) {
            return darpu * 0.15;
        } else {
            return 0;
        }
    }
}



/**
 * done
 */


package com.upcprovision.calc.services.implementations;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.model.provision.Target;
import com.upcprovision.calc.services.provision.DealsServices;
import com.upcprovision.calc.services.provision.ProvisionCalculatorServices;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;


@Service
public class ProvisionCalculatorServiceImpl implements ProvisionCalculatorServices {
    @Autowired
    public ProvisionCalculatorServiceImpl(DealsServices dealsServices) {
        this.dealsServices = dealsServices;
    }

    DealsServices dealsServices;

    @Override
    public double calc(int i, Target target) throws MathArithmeticException {
        BigDecimal q = BigDecimal.valueOf(0.2);
        BigDecimal p = BigDecimal.valueOf(0.4);
        BigDecimal a = BigDecimal.valueOf(1);
        BigDecimal b = BigDecimal.valueOf(0.3);
        BigDecimal c = BigDecimal.valueOf(1.5);
        BigDecimal d = BigDecimal.valueOf(0.6);
        BigDecimal e = BigDecimal.valueOf(1.2);
        BigDecimal f = BigDecimal.valueOf(0.8);
        try {
            BigDecimal pfcr = (target.getCfcr().divide(target.getFcr(), MathContext.DECIMAL128)).multiply(q);
            BigDecimal pnps = (target.getCnps().divide(target.getNps(), MathContext.DECIMAL128)).multiply(q);
            BigDecimal ppre = (target.getCpremium().divide(target.getPremium(), MathContext.DECIMAL128)).multiply(q);
            BigDecimal pupg = (target.getCupgrade().divide(target.getUpgrade(), MathContext.DECIMAL128)).multiply(p);
            BigDecimal wspPrem = pfcr.add(pnps.add(ppre.add(pupg)));
            BigDecimal wsp = BigDecimal.valueOf(0);
            boolean flag = true;
            boolean flag2 = true;

            if (flag && wspPrem.compareTo(e) < 0 && wspPrem.compareTo(f) > 0 || wspPrem.compareTo(f) == 0) {
                wsp = wspPrem.add(b);
                flag = false;

            } else if (flag && wspPrem.compareTo(f) < 0) {
                wsp = a;
                flag = false;

            } else if (flag && wspPrem.compareTo(e) == 0) {
                wsp = c;
                flag = false;

            } else if (flag && wspPrem.compareTo(d) > 0) {
                wsp = c;
                flag = false;
            } else if (flag2 && pfcr.compareTo(d) < 0) {
                wsp = a;
                flag2 = false;

            } else if (flag2 && pnps.compareTo(d) < 0) {
                wsp = a;
                flag2 = false;

            } else if (flag2 && ppre.compareTo(d) < 0) {
                wsp = a;
                flag2 = false;

            } else if (flag2 && pupg.compareTo(d) < 0) {
                wsp = a;
                flag2 = false;
            } else {
                flag2 = false;
                flag = false;
            }
            BigDecimal provision = target.getArpu().multiply(wsp);

            BigDecimal ret = new BigDecimal(0);
            switch (i) {
                case 0:
                    ret = provision.setScale(2, RoundingMode.DOWN);
                    break;
                case 1:
                    ret = wsp.setScale(4, RoundingMode.DOWN);
                    break;
                case 2:
                    ret = wspPrem.setScale(2, RoundingMode.DOWN);
            }

            return ret.doubleValue();
        } catch (ArithmeticException ae) {
            return 10;
        }
    }

    @Override
    public double provisionCalculatorServicesCalc(DealsDTO dealsDTO, int x) {
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
        }
        else if (segment == 4 || segment == 5) {
            d = d.add(p.multiply(BigDecimal.valueOf(0.15)));
        }
        p = p.add(d);

        if (x == 1) {
            return p.doubleValue();
        } else {
            return i.doubleValue();
        }
    }

    @Override
    public double okreslojCash(double darpu, boolean loj, boolean okresLoj) throws NullPointerException {
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

    @Override
    public double recCash(double darpu, boolean rec) {

        if (rec) {
            darpu = darpu * 0.2;
            return darpu;
        } else {
            return 0;
        }
    }

    @Override
    public double mscCash(double darpu, boolean msc) {
        if (msc) {
            darpu = darpu * 0.2;
            return darpu;
        } else {
            return 0;
        }
    }

    @Override
    public double segmentcash(double darpu, int seg) {
        if (seg == 3) {
            return darpu * 0.1;
        } else if (seg == 4 || seg == 5) {
            return darpu * 0.15;
        } else {
            return 0;
        }
    }

    @Override
    public List<Deals> findAllByLog(String log) {
        return dealsServices.findAllByLog(log);
    }

    @Override
    public double getTotalSales(List<Deals> deals) {
        int g = deals.size();
        double total = 0;
        for (Deals deal : deals) {
            total += deal.getUtarg();
        }
        return total;
    }
}
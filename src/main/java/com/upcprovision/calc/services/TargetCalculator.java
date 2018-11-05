/** done*/


package com.upcprovision.calc.services;

import com.upcprovision.calc.model.provision.Target;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


@Service
public class TargetCalculator {
    public double calc(int i, Target target) {
        BigDecimal q = BigDecimal.valueOf(0.2);
        BigDecimal p = BigDecimal.valueOf(0.4);
        BigDecimal jeden = BigDecimal.valueOf(1);
        BigDecimal dwa = BigDecimal.valueOf(0.3);
        BigDecimal trzy = BigDecimal.valueOf(1.5);
        BigDecimal cztery = BigDecimal.valueOf(0.6);
        BigDecimal piec = BigDecimal.valueOf(1.2);
        BigDecimal szesc = BigDecimal.valueOf(0.8);

BigDecimal pfcr = (target.getCfcr().divide(target.getFcr(), MathContext.DECIMAL128)).multiply(q);
BigDecimal pnps = (target.getCnps().divide(target.getNps(), MathContext.DECIMAL128)).multiply(q);
BigDecimal ppre = (target.getCpremium().divide(target.getPremium(), MathContext.DECIMAL128)).multiply(q);
BigDecimal pupg = (target.getCupgrade().divide(target.getUpgrade(), MathContext.DECIMAL128)).multiply(p);
        BigDecimal wspPrem = pfcr.add(pnps.add(ppre.add(pupg)));
        BigDecimal wsp = BigDecimal.valueOf(0);
        boolean flag = true;
        boolean flag2 = true;


        if (flag && wspPrem.compareTo(piec) < 0 && wspPrem.compareTo(szesc) > 0 || wspPrem.compareTo(szesc) == 0) {
            wsp = wspPrem.add(dwa);
            flag = false;

        } else if (flag && wspPrem.compareTo(szesc) < 0) {
            wsp = jeden;
            flag = false;

        } else if (flag && wspPrem.compareTo(piec) == 0) {
            wsp = trzy;
            flag = false;

        } else if (flag && wspPrem.compareTo(cztery) > 0) {
            wsp = trzy;
            flag = false;
        } else if (flag2 && pfcr.compareTo(cztery) < 0) {
            wsp = jeden;
            flag2 = false;

        } else if (flag2 && pnps.compareTo(cztery) < 0) {
            wsp = jeden;
            flag2 = false;

        } else if (flag2 && ppre.compareTo(cztery) < 0) {
            wsp = jeden;
            flag2 = false;

        } else if (flag2 && pupg.compareTo(cztery) < 0) {
            wsp = jeden;
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
    }
}
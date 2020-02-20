/**
 * done
 */


package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.model.provision.Target;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


@Service
public class    ProvisionFinal {
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
}
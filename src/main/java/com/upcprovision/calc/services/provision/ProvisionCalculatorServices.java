package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.model.provision.Target;
import org.apache.commons.math3.exception.MathArithmeticException;

import java.util.List;

public interface ProvisionCalculatorServices {
    double calc(int i, Target target) throws MathArithmeticException;
    double provisionCalculatorServicesCalc(DealsDTO dealsDTO, int x);
    double okreslojCash(double darpu, boolean loj, boolean okresLoj) throws NullPointerException;
    double recCash(double darpu, boolean rec);
    double mscCash(double darpu, boolean msc);
    double segmentcash(double darpu, int seg);
    List<Deals> findAllByLog(String log);
    double getTotalSales(List<Deals> deals);
}

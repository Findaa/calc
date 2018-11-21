package com.upcprovision.calc.tests;

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.provision.ProvisionTotal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProvisionTotalTest {

    ProvisionTotal provisionTotal = new ProvisionTotal(null);

    @Test
    public void getTotalSales() {
        List<Deals> dealsList = new ArrayList<>();
        dealsList.add(new Deals("1", 1, 1, 1, true, true, true, true, 10));
        dealsList.add(new Deals("1", 1, 1, 1, true, true, true, true, 10));

        assert provisionTotal.getTotalSales(dealsList) == 20;
    }
}

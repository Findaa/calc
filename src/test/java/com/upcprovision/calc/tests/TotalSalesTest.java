package com.upcprovision.calc.tests;

import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.TotalSales;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TotalSalesTest {

    TotalSales totalSales = new TotalSales(null);

    @Test
    public void getTotalSales() {
        List<Deals> dealsList = new ArrayList<>();
        dealsList.add(new Deals("1", 1, 1, 1, true, true, true, true, 10));
        dealsList.add(new Deals("1", 1, 1, 1, true, true, true, true, 10));

        assert totalSales.getTotalSales(dealsList) == 20;
    }
}

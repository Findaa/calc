//package
//
//import com.upcprovision.calc.model.provision.Deals;
//import com.upcprovision.calc.services.provision.ProvisionCalculatorServices;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProvisionCalculatorServicesTest {
//
//    private ProvisionCalculatorServices provisionCalculatorServices = new ProvisionCalculatorServices(null);
//
//    @Test
//    public void getTotalSales() {
//        List<Deals> dealsList = new ArrayList<>();
//        dealsList.add(new Deals("1", 1, 1, 1, true, true, true, true, 10));
//        dealsList.add(new Deals("1", 1, 1, 1, true, true, true, true, 10));
//
//        assert provisionCalculatorServices.getTotalSales(dealsList) == 20;
//    }
//}

package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.provision.Deals;
import org.springframework.stereotype.Service;

@Service
public interface ConvertServices {
    Deals convert(DealsDTO dealsDTO, ProvisionCalculatorServices provisionCalculatorServices);
    Deals convert(Long id, DealsDTO dealsDTO, ProvisionCalculatorServices provisionCalculatorServices);
}

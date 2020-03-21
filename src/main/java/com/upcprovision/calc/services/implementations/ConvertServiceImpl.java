package com.upcprovision.calc.services.implementations;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.provision.Deals;
import com.upcprovision.calc.services.provision.ConvertServices;
import com.upcprovision.calc.services.provision.DealsServices;
import com.upcprovision.calc.services.provision.ProvisionCalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertServices {
    @Autowired
    public ConvertServiceImpl (DealsServices dealsServices) {
        this.dealsServices = dealsServices;
    }

    private DealsServices dealsServices;

    @Override
    public Deals convert(DealsDTO dealsDTO, ProvisionCalculatorServices provisionCalculatorServices) {
        return new Deals(
                dealsDTO.getLog(),
                dealsDTO.getClientId(),
                dealsDTO.getDarpu(),
                dealsDTO.getSegment(),
                dealsDTO.isLoj(),
                dealsDTO.isRecomended(),
                dealsDTO.isOkresloj(),
                dealsDTO.isMsc(),
                provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 1),
                provisionCalculatorServices.okreslojCash(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 2),
                dealsDTO.isLoj(),
                dealsDTO.isOkresloj()),
                provisionCalculatorServices.recCash(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 2),
                dealsDTO.isRecomended()),
                provisionCalculatorServices.mscCash(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 2),
                dealsDTO.isMsc()),
                provisionCalculatorServices.segmentcash(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 2),
                dealsDTO.getSegment()),
                dealsDTO.isnewClient());
    }

    @Override
    public Deals convert(Long id, DealsDTO dealsDTO, ProvisionCalculatorServices provisionCalculatorServices) {
        Deals deal = dealsServices.findAllById(id);
        if (deal != null) {
            deal.setId(id);
            deal.setLog(dealsDTO.getLog());
            deal.setClientId(dealsDTO.getClientId());
            deal.setDarpu(dealsDTO.getDarpu());
            deal.setSegment(dealsDTO.getSegment());
            deal.setLoj(dealsDTO.isLoj());
            deal.setRecomended(dealsDTO.isRecomended());
            deal.setOkresLoj(dealsDTO.isOkresloj());
            deal.setMsc(dealsDTO.isMsc());
            deal.setUtarg(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 1));
            deal.setLojCash(provisionCalculatorServices.okreslojCash(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 2), dealsDTO.isLoj(), dealsDTO.isOkresloj()));
            deal.setRecCash(provisionCalculatorServices.recCash(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 2), dealsDTO.isRecomended()));
            deal.setMscCash(provisionCalculatorServices.mscCash(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 2), dealsDTO.isMsc()));
            deal.setSegCash(provisionCalculatorServices.segmentcash(provisionCalculatorServices.provisionCalculatorServicesCalc(dealsDTO, 2), dealsDTO.getSegment()));
            deal.setNewClient(dealsDTO.isnewClient());
            return deal;
        } else {
            try {
                return convert(dealsDTO, provisionCalculatorServices);
            } catch (NullPointerException npe){
                return null;
            }
        }
    }
}


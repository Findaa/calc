package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.provision.Deals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    DealsServices dealsServices;

    @Autowired
    public ConvertService(DealsServices dealsServices) {
        this.dealsServices = dealsServices;
    }

    public Deals convert(DealsDTO dealsDTO, ProvisionSingle provisionSingle) {
        return new Deals(dealsDTO.getLog(), dealsDTO.getClientid(), dealsDTO.getDarpu(), dealsDTO.getSegment(),
                dealsDTO.isLoj(), dealsDTO.isRecomended(), dealsDTO.isOkresloj(), dealsDTO.isMsc(),
                provisionSingle.provisionSinglenCalc(dealsDTO, 1), provisionSingle.okreslojcash(provisionSingle.provisionSinglenCalc(dealsDTO, 2),
                dealsDTO.isLoj(), dealsDTO.isOkresloj()), provisionSingle.reccash(provisionSingle.provisionSinglenCalc(dealsDTO, 2),
                dealsDTO.isRecomended()), provisionSingle.msccash(provisionSingle.provisionSinglenCalc(dealsDTO, 2), dealsDTO.isMsc()),
                provisionSingle.segmentcash(provisionSingle.provisionSinglenCalc(dealsDTO, 2), dealsDTO.getSegment()), dealsDTO.isNewclient());
    }

    public Deals convert(Long id, DealsDTO dealsDTO, ProvisionSingle provisionSingle) {
        Deals deal = dealsServices.findAllById(id);
        if(deal != null) {
            deal.setId(id);
            deal.setLog(dealsDTO.getLog());
            deal.setClientid(dealsDTO.getClientid());
            deal.setDarpu(dealsDTO.getDarpu());
            deal.setSegment(dealsDTO.getSegment());
            deal.setLoj(dealsDTO.isLoj());
            deal.setRecomended(dealsDTO.isRecomended());
            deal.setOkresloj(dealsDTO.isOkresloj());
            deal.setMsc(dealsDTO.isMsc());
            deal.setUtarg(provisionSingle.provisionSinglenCalc(dealsDTO, 1));
            deal.setLojcash(provisionSingle.okreslojcash(provisionSingle.provisionSinglenCalc(dealsDTO, 2), dealsDTO.isLoj(), dealsDTO.isOkresloj()));
            deal.setReccash(provisionSingle.reccash(provisionSingle.provisionSinglenCalc(dealsDTO, 2), dealsDTO.isRecomended()));
            deal.setMsccash(provisionSingle.msccash(provisionSingle.provisionSinglenCalc(dealsDTO, 2), dealsDTO.isMsc()));
            deal.setSegcash(provisionSingle.segmentcash(provisionSingle.provisionSinglenCalc(dealsDTO, 2), dealsDTO.getSegment()));
            deal.setNewclient(dealsDTO.isNewclient());
            return deal;
        } else {
            return convert(dealsDTO, provisionSingle);
        }
    }
}


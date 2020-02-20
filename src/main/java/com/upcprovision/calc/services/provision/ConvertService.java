package com.upcprovision.calc.services.provision;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.provision.Deals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    private DealsServices dealsServices;

    @Autowired
    public ConvertService(DealsServices dealsServices) {
        this.dealsServices = dealsServices;
    }

    public Deals convert(DealsDTO dealsDTO, ProvisionSingle provisionSingle) {
        return new Deals(
                dealsDTO.getLog(),
                dealsDTO.getClientId(),
                dealsDTO.getDarpu(),
                dealsDTO.getSegment(),
                dealsDTO.isLoj(),
                dealsDTO.isRecomended(),
                dealsDTO.isOkresloj(),
                dealsDTO.isMsc(),
                provisionSingle.provisionSingleCalc(dealsDTO, 1),
                provisionSingle.okreslojCash(provisionSingle.provisionSingleCalc(dealsDTO, 2),
                dealsDTO.isLoj(),
                dealsDTO.isOkresloj()),
                provisionSingle.recCash(provisionSingle.provisionSingleCalc(dealsDTO, 2),
                dealsDTO.isRecomended()),
                provisionSingle.mscCash(provisionSingle.provisionSingleCalc(dealsDTO, 2),
                dealsDTO.isMsc()),
                provisionSingle.segmentcash(provisionSingle.provisionSingleCalc(dealsDTO, 2),
                dealsDTO.getSegment()),
                dealsDTO.isnewClient());
    }

    public Deals convert(Long id, DealsDTO dealsDTO, ProvisionSingle provisionSingle) {
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
            deal.setUtarg(provisionSingle.provisionSingleCalc(dealsDTO, 1));
            deal.setLojCash(provisionSingle.okreslojCash(provisionSingle.provisionSingleCalc(dealsDTO, 2), dealsDTO.isLoj(), dealsDTO.isOkresloj()));
            deal.setRecCash(provisionSingle.recCash(provisionSingle.provisionSingleCalc(dealsDTO, 2), dealsDTO.isRecomended()));
            deal.setmscCash(provisionSingle.mscCash(provisionSingle.provisionSingleCalc(dealsDTO, 2), dealsDTO.isMsc()));
            deal.setSegCash(provisionSingle.segmentcash(provisionSingle.provisionSingleCalc(dealsDTO, 2), dealsDTO.getSegment()));
            deal.setNewClient(dealsDTO.isnewClient());
            return deal;
        } else {
            try {
                return convert(dealsDTO, provisionSingle);
            } catch (NullPointerException npe){
                return null;
            }
        }
    }
}


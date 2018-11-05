package com.upcprovision.calc.services;

import com.upcprovision.calc.dto.DealsDTO;
import com.upcprovision.calc.model.provision.Deals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    @Autowired
    DealsServices dealsServices;

    public Deals convert(DealsDTO dealsDTO, UtargCalc utargCalc) {
        return new Deals(dealsDTO.getLog(), dealsDTO.getClientid(), dealsDTO.getDarpu(), dealsDTO.getSegment(),
                dealsDTO.isLoj(), dealsDTO.isRecomended(), dealsDTO.isOkresloj(), dealsDTO.isMsc(),
                utargCalc.utargcalc(dealsDTO, 1), utargCalc.okreslojcash(utargCalc.utargcalc(dealsDTO, 2),
                dealsDTO.isLoj(), dealsDTO.isOkresloj()), utargCalc.reccash(utargCalc.utargcalc(dealsDTO, 2),
                dealsDTO.isRecomended()), utargCalc.msccash(utargCalc.utargcalc(dealsDTO, 2), dealsDTO.isMsc()),
                utargCalc.segmentcash(utargCalc.utargcalc(dealsDTO, 2), dealsDTO.getSegment()), dealsDTO.isNewclient(),
                dealsDTO.isCanalupgr(), dealsDTO.isHboupgr(), dealsDTO.isDtvupgr(), dealsDTO.isInteupgr(),
                dealsDTO.isTelupgr(), dealsDTO.isCinemax(), dealsDTO.isFilmbox(), dealsDTO.isFilmklub(),
                dealsDTO.isCanal(), dealsDTO.isHbo(), dealsDTO.isDtv(), dealsDTO.isInte(), dealsDTO.isTel(),
                dealsDTO.isHzn(), dealsDTO.isExtra(), dealsDTO.isMyprime(), dealsDTO.isMegasport(), dealsDTO.isPsp());
    }

    public Deals convert(Long id, DealsDTO dealsDTO, UtargCalc utargCalc) {
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
            deal.setUtarg(utargCalc.utargcalc(dealsDTO, 1));
            deal.setLojcash(utargCalc.okreslojcash(utargCalc.utargcalc(dealsDTO, 2), dealsDTO.isLoj(), dealsDTO.isOkresloj()));
            deal.setReccash(utargCalc.reccash(utargCalc.utargcalc(dealsDTO, 2), dealsDTO.isRecomended()));
            deal.setMsccash(utargCalc.msccash(utargCalc.utargcalc(dealsDTO, 2), dealsDTO.isMsc()));
            deal.setSegcash(utargCalc.segmentcash(utargCalc.utargcalc(dealsDTO, 2), dealsDTO.getSegment()));
            deal.setNewclient(dealsDTO.isNewclient());
            deal.setCanalupgr(dealsDTO.isCanalupgr());
            deal.setHboupgr(dealsDTO.isHboupgr());
            deal.setDtvupgr(dealsDTO.isDtvupgr());
            deal.setInteupgr(dealsDTO.isInteupgr());
            deal.setTelupgr(dealsDTO.isTelupgr());
            deal.setCinemax(dealsDTO.isCinemax());
            deal.setFilmbox(dealsDTO.isFilmbox());
            deal.setFilmklub(dealsDTO.isFilmklub());
            deal.setCanal(dealsDTO.isCanal());
            deal.setHbo(dealsDTO.isHbo());
            deal.setDtv(dealsDTO.isDtv());
            deal.setInte(dealsDTO.isInte());
            deal.setTel(dealsDTO.isTel());
            deal.setHzn(dealsDTO.isHzn());
            deal.setExtra(dealsDTO.isExtra());
            deal.setMyprime(dealsDTO.isMyprime());
            deal.setMegasport(dealsDTO.isMegasport());
            deal.setPsp(dealsDTO.isPsp());
            return deal;
        } else {
            return convert(dealsDTO, utargCalc);
        }

    }
}


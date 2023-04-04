package com.realestate.service.impl;

import com.realestate.entity.ClientReg;
import com.realestate.entity.Visit;
import com.realestate.exception.ResourceNotFoundException;
import com.realestate.payload.VisitDto;
import com.realestate.repository.ClientRegRepository;
import com.realestate.repository.VisitRepository;
import com.realestate.service.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl implements VisitService {

    private VisitRepository visitRepository;

    private ClientRegRepository clientRegRepository;

    public VisitServiceImpl(VisitRepository visitRepository,ClientRegRepository clientRegRepository) {
        this.visitRepository = visitRepository;
        this.clientRegRepository=clientRegRepository;
    }


    @Override
    public VisitDto createVisit(VisitDto visitDto) {
       ClientReg clientReg = clientRegRepository.findById(visitDto.getClientId()).orElseThrow(
                () -> new ResourceNotFoundException("Client Id not present", "id", visitDto.getClientId())
       );
        Visit visit=new Visit();
        visit.setClientId(visitDto.getClientId());
        visit.setAgentId(visitDto.getAgentId());
        visit.setVisitDate(visitDto.getVisitDate());
      //  visit.setClientReg(clientReg);
        visit.setPropertyId(visitDto.getPropertyId());
        Visit save = visitRepository.save(visit);
        //VisitDto visitDto1 = mapToDto(save);
        VisitDto Dto= new VisitDto();
        Dto.setVisitDate(save.getVisitDate());
        Dto.setClientId(save.getClientId());
        Dto.setPropertyId(save.getPropertyId());
        Dto.setAgentId(save.getAgentId());
        Dto.setClientReg(clientReg);
        return Dto;
    }

//    private Visit mapToEntity(VisitDto visitDto) {
//
//        return visit;
//    }
//    private VisitDto mapToDto(Visit save){
//        VisitDto visitDto= new VisitDto();
//        visitDto.setVisitDate(save.getVisitDate());
//        visitDto.setClientId(save.getClientId());
//        visitDto.setPropertyId(save.getPropertyId());
//        visitDto.setAgentId(save.getAgentId());
//        visitDto.setClientReg(save.getClientReg());
//        return visitDto;
//    }
}

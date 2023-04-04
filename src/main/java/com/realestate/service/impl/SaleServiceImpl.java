package com.realestate.service.impl;

import com.realestate.entity.ClientReg;
import com.realestate.entity.Sale;
import com.realestate.payload.SaleDto;
import com.realestate.repository.ClientRegRepository;
import com.realestate.repository.SaleRepository;
import com.realestate.service.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class SaleServiceImpl implements SaleService {


    private ClientRegRepository clientRegRepository;


    private SaleRepository saleRepository;


    private ModelMapper modelMapper;

    public SaleServiceImpl(ClientRegRepository clientRegRepository, SaleRepository saleRepository, ModelMapper modelMapper) {
        this.clientRegRepository = clientRegRepository;
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SaleDto saveSale(SaleDto saleDTO) {
        ClientReg clientReg = clientRegRepository.findById(saleDTO.getClientId()).orElseThrow(
                () -> new EntityNotFoundException("Client Id is not present" + saleDTO.getClientId())
        );
        Sale sale = convertToEntity(saleDTO);
        sale.setClientReg(clientReg);
        Sale newSale = saleRepository.save(sale);
        SaleDto saleDto = convertToDTO(newSale);
        saleDto.setClientReg(newSale.getClientReg());
        return saleDto;
    }

    private Sale convertToEntity(SaleDto saleDTO) {
        return modelMapper.map(saleDTO, Sale.class);
    }

    private SaleDto convertToDTO(Sale newSale) {
        return modelMapper.map(newSale, SaleDto.class);
    }
}

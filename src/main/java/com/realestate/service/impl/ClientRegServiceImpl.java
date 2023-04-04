package com.realestate.service.impl;

import com.realestate.entity.ClientReg;
import com.realestate.payload.ClientRegDto;
import com.realestate.repository.ClientRegRepository;
import com.realestate.service.ClientRegService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientRegServiceImpl implements ClientRegService {

    private ClientRegRepository clientRegRepository;


    private ModelMapper modelMapper;

    public ClientRegServiceImpl(ClientRegRepository clientRegRepository, ModelMapper modelMapper) {
        this.clientRegRepository = clientRegRepository;
        this.modelMapper = modelMapper;
    }

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public ClientRegDto save(ClientRegDto clientRegDTO) {
        ClientReg clientReg = modelMapper.map(clientRegDTO, ClientReg.class);
        // Set the encoded password
        clientReg.setPassword(passwordEncoder().encode(clientRegDTO.getPassword()));
        ClientReg savedClientReg = clientRegRepository.save(clientReg);
        return modelMapper.map(savedClientReg, ClientRegDto.class);
    }
}

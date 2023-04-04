package com.realestate.controller;

import com.realestate.payload.ClientRegDto;
import com.realestate.service.ClientRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client-reg")
public class ClientRegController {


    private ClientRegService clientRegService;

    public ClientRegController(ClientRegService clientRegService) {
        this.clientRegService = clientRegService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClientRegDto> createClientReg(@RequestBody ClientRegDto clientRegDTO) {
           ClientRegDto savedClientRegDTO = clientRegService.save(clientRegDTO);
        return new ResponseEntity<>(savedClientRegDTO, HttpStatus.CREATED);
    }
}


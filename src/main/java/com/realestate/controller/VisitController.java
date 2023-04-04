package com.realestate.controller;


import com.realestate.payload.VisitDto;
import com.realestate.service.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visit")
public class VisitController {

    private VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping
    public ResponseEntity<VisitDto> createVisit(@RequestBody VisitDto visitDto){
        return new ResponseEntity<>(visitService.createVisit(visitDto), HttpStatus.CREATED);

    }
}

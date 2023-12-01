package com.guianella.backend_textil.infraestructure.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guianella.backend_textil.domain.model.dto.InvestmentDTO;
import com.guianella.backend_textil.domain.model.dto.request.InvestmentRequest;

@RestController
@RequestMapping("/api/v1/investment")
public class InvestmentController {
    
    @PostMapping
    public ResponseEntity<InvestmentDTO> create(@RequestBody InvestmentRequest investmentRequest){
        return new ResponseEntity<>(new InvestmentDTO(), HttpStatus.CREATED);
    }

}

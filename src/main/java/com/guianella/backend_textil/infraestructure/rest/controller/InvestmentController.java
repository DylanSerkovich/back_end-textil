package com.guianella.backend_textil.infraestructure.rest.controller;

import com.guianella.backend_textil.domain.model.dto.request.InvestmentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investment")
public class InvestmentController {
    
    @PostMapping
    public ResponseEntity<InvestmentRequest> create(@RequestBody @Validated InvestmentRequest investmentRequest){

        return new ResponseEntity<>(investmentRequest, HttpStatus.CREATED);
    }

}

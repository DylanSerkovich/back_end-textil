package com.guianella.backend_textil.application.service;

import com.guianella.backend_textil.application.usecases.InvestmentService;
import com.guianella.backend_textil.domain.model.dto.InvestmentDTO;
import com.guianella.backend_textil.domain.model.dto.request.InvestmentRequest;

public class InvestmentManagementService implements InvestmentService{

    @Override
    public InvestmentDTO createNew(InvestmentRequest investmentRequest) {
        
        throw new UnsupportedOperationException("Unimplemented method 'createNew'");
    }
    
}

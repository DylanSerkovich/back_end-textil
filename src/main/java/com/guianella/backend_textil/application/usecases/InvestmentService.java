package com.guianella.backend_textil.application.usecases;

import com.guianella.backend_textil.domain.model.dto.InvestmentDTO;
import com.guianella.backend_textil.domain.model.dto.request.InvestmentRequest;

public interface InvestmentService {

    InvestmentDTO createNew(InvestmentRequest investmentRequest);
}

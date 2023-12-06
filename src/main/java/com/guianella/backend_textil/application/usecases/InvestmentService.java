package com.guianella.backend_textil.application.usecases;

import com.guianella.backend_textil.domain.model.dto.InvestmentDto;
import com.guianella.backend_textil.domain.model.dto.request.InvestmentRequest;

public interface InvestmentService {

    InvestmentDto createNew(InvestmentRequest investmentRequest);
}

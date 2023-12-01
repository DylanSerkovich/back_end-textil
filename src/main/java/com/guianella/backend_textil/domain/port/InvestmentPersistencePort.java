package com.guianella.backend_textil.domain.port;

import com.guianella.backend_textil.domain.model.Investment;

public interface InvestmentPersistencePort {

    Investment create(Investment request);

}

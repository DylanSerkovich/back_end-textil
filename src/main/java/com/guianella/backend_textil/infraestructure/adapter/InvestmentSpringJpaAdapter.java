package com.guianella.backend_textil.infraestructure.adapter;

import com.guianella.backend_textil.domain.model.Investment;
import com.guianella.backend_textil.domain.port.InvestmentPersistencePort;
import com.guianella.backend_textil.infraestructure.adapter.repository.InvestmentRepository;

public class InvestmentSpringJpaAdapter implements InvestmentPersistencePort {

    private final InvestmentRepository investmentRepository;

    public InvestmentSpringJpaAdapter(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @Override
    public Investment create(Investment request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

}

package com.guianella.backend_textil.infraestructure.adapter;

import com.guianella.backend_textil.domain.model.Investment;
import com.guianella.backend_textil.domain.port.InvestmentPersistencePort;
import com.guianella.backend_textil.infraestructure.adapter.entity.InvestmentEntity;
import com.guianella.backend_textil.infraestructure.adapter.mapper.InvestmentDboMapper;
import com.guianella.backend_textil.infraestructure.adapter.repository.InvestmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InvestmentSpringJpaAdapter implements InvestmentPersistencePort {

    private final InvestmentRepository investmentRepository;


    public InvestmentSpringJpaAdapter(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @Override
    public Investment create(Investment request) {
        InvestmentEntity investmentToSaved = InvestmentDboMapper.toDbo(request);
        investmentToSaved.getFabrics().forEach(fabric -> fabric.setIdInvestment(investmentToSaved));
        var investmentSaved = investmentRepository.save(investmentToSaved);
        return InvestmentDboMapper.toDomain(investmentSaved);
    }

}

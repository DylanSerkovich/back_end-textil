package com.guianella.backend_textil.application.service;

import com.guianella.backend_textil.application.mapper.InvestmentDtoMapper;
import com.guianella.backend_textil.application.usecases.InvestmentService;
import com.guianella.backend_textil.domain.model.Fabric;
import com.guianella.backend_textil.domain.model.Investment;
import com.guianella.backend_textil.domain.model.dto.InvestmentDto;
import com.guianella.backend_textil.domain.model.dto.request.FabricRequest;
import com.guianella.backend_textil.domain.model.dto.request.InvestmentRequest;
import com.guianella.backend_textil.domain.port.ColorFabricPersistencePort;
import com.guianella.backend_textil.domain.port.InvestmentPersistencePort;
import com.guianella.backend_textil.domain.port.TypeFabricPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class InvestmentManagementService implements InvestmentService{

    private final InvestmentPersistencePort investmentPersistencePort;
    private final ColorFabricPersistencePort colorFabricPersistencePort;
    private final TypeFabricPersistencePort typeFabricPersistencePort;


    @Autowired
    public InvestmentManagementService(final InvestmentPersistencePort investmentPersistencePort,
                                       final ColorFabricPersistencePort colorFabricPersistencePort,
                                       final TypeFabricPersistencePort typeFabricPersistencePort){
        this.investmentPersistencePort = investmentPersistencePort;
        this.colorFabricPersistencePort = colorFabricPersistencePort;
        this.typeFabricPersistencePort = typeFabricPersistencePort;
    }

    @Override
    public InvestmentDto createNew(InvestmentRequest investmentRequest) {

        var investmentToCreate = Investment.builder()
                .investorName("User")
                .unitSales(investmentRequest.getUnitSales())
                .fabricList(investmentRequest.getFabrics().stream()
                        .map(this::initializerFabrics)
                        .collect(Collectors.toList()))
                .build();
        
        var investment = investmentPersistencePort.create(investmentToCreate);

        return InvestmentDtoMapper.toDto(investment);
    }

    private Fabric initializerFabrics(FabricRequest request){
        return Fabric.builder()
                .colorFabric(colorFabricPersistencePort.getById(request.getIdColorFabric()))
                .typeFabric(typeFabricPersistencePort.getById(request.getIdTypeFabric()))
                .size(request.getSize())
                .yield(request.getYield())
                .sizeCost(request.getSizeCost())
                .build();
    }
    
}

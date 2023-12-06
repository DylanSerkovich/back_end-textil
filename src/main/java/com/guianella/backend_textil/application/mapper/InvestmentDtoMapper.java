package com.guianella.backend_textil.application.mapper;

import com.guianella.backend_textil.domain.model.Investment;
import com.guianella.backend_textil.domain.model.dto.InvestmentDto;

import java.util.stream.Collectors;

public class InvestmentDtoMapper {

    public static InvestmentDto toDto(Investment investment){
        return new InvestmentDto(investment.getId(),
                investment.getInvestorName(),
                investment.getCompleteDate(),
                investment.getCreateDate(),
                investment.getUnitSales(),
                investment.getFabricList().stream().map(FabricDtoMapper::toDto).collect(Collectors.toList()));
    }
}

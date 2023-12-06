package com.guianella.backend_textil.infraestructure.adapter.mapper;

import com.guianella.backend_textil.domain.model.Investment;
import com.guianella.backend_textil.infraestructure.adapter.entity.InvestmentEntity;
import com.guianella.backend_textil.infraestructure.adapter.util.UnitSales;

import java.util.stream.Collectors;

public class InvestmentDboMapper {

    public static InvestmentEntity toDbo(Investment request){
        return InvestmentEntity.builder()
                .investorName(request.getInvestorName())
                .unitSales(UnitSales.valueOf(request.getUnitSales()))
                .fabrics(request.getFabricList().stream().map(FabricDboMapper::toDbo).collect(Collectors.toList()))
                .build();
    }

    public static Investment toDomain(InvestmentEntity entity){
        return Investment.builder()
                .id(entity.getId())
                .investorName(entity.getInvestorName())
                .unitSales(entity.getUnitSales().name())
                .createDate(entity.getCreateDate())
                .createDate(entity.getCreateDate())
                .fabricList(entity.getFabrics().stream().map(FabricDboMapper::toDomain).collect(Collectors.toList()))
                .build();
    }
}

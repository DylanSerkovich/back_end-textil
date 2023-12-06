package com.guianella.backend_textil.infraestructure.adapter.mapper;

import com.guianella.backend_textil.domain.model.Fabric;
import com.guianella.backend_textil.infraestructure.adapter.entity.FabricEntity;

public class FabricDboMapper {

    public static FabricEntity toDbo(Fabric fabric){
        return FabricEntity.builder()
                .idColorFabric(ColorDboMapper.toDbo(fabric.getColorFabric()))
                .idTypeFabric(TypeFabricDboMapper.toDbo(fabric.getTypeFabric()))
                .size(fabric.getSize())
                .yield(fabric.getYield())
                .sizeCost(fabric.getSizeCost())
                .build();
    }

    public static Fabric toDomain(FabricEntity entity){
        return Fabric.builder()
                .id(entity.getId())
                .colorFabric(ColorDboMapper.toDomain(entity.getIdColorFabric()))
                .typeFabric(TypeFabricDboMapper.toDomain(entity.getIdTypeFabric()))
                .size(entity.getSize())
                .yield(entity.getYield())
                .sizeCost(entity.getSizeCost())
                .build();
    }
}

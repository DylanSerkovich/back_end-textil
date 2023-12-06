package com.guianella.backend_textil.application.mapper;

import com.guianella.backend_textil.domain.model.Fabric;
import com.guianella.backend_textil.domain.model.dto.FabricDto;

public class FabricDtoMapper {

    public static FabricDto toDto(Fabric fabric){
        return new FabricDto(fabric.getId(),TypeFabricDtoMapper.toDto(fabric.getTypeFabric()),ColorFabricDtoMapper.toDto(fabric.getColorFabric()),fabric.getSize(),fabric.getYield(),fabric.getSizeCost());
    }
}

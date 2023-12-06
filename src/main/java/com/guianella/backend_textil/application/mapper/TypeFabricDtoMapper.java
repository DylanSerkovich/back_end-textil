package com.guianella.backend_textil.application.mapper;

import com.guianella.backend_textil.domain.model.TypeFabric;
import com.guianella.backend_textil.domain.model.dto.TypeFabricDto;

public class TypeFabricDtoMapper {
    public static TypeFabricDto toDto(TypeFabric typeFabric){
        return new TypeFabricDto(typeFabric.getId(),typeFabric.getTypeName());
    }
}

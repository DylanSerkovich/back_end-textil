package com.guianella.backend_textil.application.mapper;

import com.guianella.backend_textil.domain.model.TypeFabric;
import com.guianella.backend_textil.domain.model.dto.request.TypeFabricRequest;

public class TypeFabricRequestMapper {
    public static TypeFabric toDomain(TypeFabricRequest request){
        return TypeFabric.builder()
                .typeName(request.getTypeName())
                .build();
    }
}

package com.guianella.backend_textil.infraestructure.adapter.mapper;

import com.guianella.backend_textil.domain.model.TypeFabric;
import com.guianella.backend_textil.infraestructure.adapter.entity.TypeFabricEntity;

public class TypeFabricDboMapper {

    public static TypeFabric toDomain(TypeFabricEntity entity){
        return TypeFabric.builder()
                .id(entity.getId())
                .typeName(entity.getTypeName())
                .build();
    }

    public static TypeFabricEntity toDbo(TypeFabric typeFabric){
        return TypeFabricEntity.builder()
                .id(typeFabric.getId())
                .typeName(typeFabric.getTypeName())
                .build();

    }
}

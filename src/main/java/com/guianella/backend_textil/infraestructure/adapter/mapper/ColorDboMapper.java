package com.guianella.backend_textil.infraestructure.adapter.mapper;

import com.guianella.backend_textil.domain.model.ColorFabric;
import com.guianella.backend_textil.infraestructure.adapter.entity.ColorFabricEntity;

public class ColorDboMapper {
    public static ColorFabric toDomain(ColorFabricEntity entity){
        return ColorFabric.builder()
                .id(entity.getId())
                .nameColor(entity.getNameColor())
                .hexadecimal(entity.getHexadecimal())
                .build();
    }

    public static ColorFabricEntity toDbo(ColorFabric colorFabric){
        return ColorFabricEntity.builder()
                .id(colorFabric.getId())
                .nameColor(colorFabric.getNameColor())
                .hexadecimal(colorFabric.getHexadecimal())
                .build();
    }
}

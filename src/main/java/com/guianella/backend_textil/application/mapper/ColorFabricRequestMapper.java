package com.guianella.backend_textil.application.mapper;

import com.guianella.backend_textil.domain.model.ColorFabric;
import com.guianella.backend_textil.domain.model.dto.request.ColorFabricRequest;

public class ColorFabricRequestMapper {
    public static ColorFabric toDomain(ColorFabricRequest request){
        return ColorFabric.builder()
                .nameColor(request.getName())
                .hexadecimal(request.getHexadecimal())
                .build();
    }
}

package com.guianella.backend_textil.application.mapper;

import com.guianella.backend_textil.domain.model.ColorFabric;
import com.guianella.backend_textil.domain.model.dto.ColorFabricDto;

public class ColorFabricDtoMapper {
    public static ColorFabricDto toDto(ColorFabric colorFabric){
        return new ColorFabricDto(colorFabric.getId(),colorFabric.getNameColor(),colorFabric.getHexadecimal());
    }
}

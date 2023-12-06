package com.guianella.backend_textil.domain.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.guianella.backend_textil.infraestructure.adapter.entity.FabricEntity}
 */
public record FabricDto(Long id,
                        TypeFabricDto TypeFabricDto,
                        ColorFabricDto ColorFabricDto,
                        BigDecimal size,
                        BigDecimal yield,
                        BigDecimal sizeCost)
        implements Serializable {
}
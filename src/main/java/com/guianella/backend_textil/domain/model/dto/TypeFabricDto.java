package com.guianella.backend_textil.domain.model.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.guianella.backend_textil.infraestructure.adapter.entity.TypeFabricEntity}
 */
public record TypeFabricDto(
        Long id,
        String typeName)
        implements Serializable {
}
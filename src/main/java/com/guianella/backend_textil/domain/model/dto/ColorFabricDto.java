package com.guianella.backend_textil.domain.model.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.guianella.backend_textil.infraestructure.adapter.entity.ColorFabricEntity}
 */
public record ColorFabricDto(
        Long id,
        String nameColor,
        String hexadecimal)
        implements Serializable {
}
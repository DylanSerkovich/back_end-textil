package com.guianella.backend_textil.domain.model.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * DTO for {@link com.guianella.backend_textil.infraestructure.adapter.entity.InvestmentEntity}
 */
public record InvestmentDto(Long id,
                            String investorName,
                            Instant completeDate,
                            Instant createDate,
                            String unitSales,
                            List<FabricDto> FabricDto) implements Serializable {
}
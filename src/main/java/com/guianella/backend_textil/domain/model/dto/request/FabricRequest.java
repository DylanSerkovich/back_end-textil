package com.guianella.backend_textil.domain.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FabricRequest {
    private long idTypeFabric;
    private long idColorFabric;
    @NotNull
    private BigDecimal size;
    @NotNull
    private BigDecimal yield;
    @NotNull
    private BigDecimal sizeCost;

}

package com.guianella.backend_textil.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Fabric {
    private long id;
    private TypeFabric typeFabric;
    private ColorFabric colorFabric;
    BigDecimal size;
    BigDecimal yield;
    BigDecimal sizeCost;
}

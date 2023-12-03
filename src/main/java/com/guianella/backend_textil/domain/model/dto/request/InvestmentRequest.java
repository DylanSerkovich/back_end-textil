package com.guianella.backend_textil.domain.model.dto.request;

import com.guianella.backend_textil.infraestructure.adapter.util.UnitSales;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvestmentRequest {

    @NotNull(message = "unitsales no puede estar en blanco")
    private UnitSales unitSales;

    @Valid
    private List<FabricRequest> fabrics = new ArrayList<>();

//    public UnitSales getUnitSalesEnum() {
//        return UnitSales.valueOf(unitSales);
//    }
}

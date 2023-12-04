package com.guianella.backend_textil.domain.model.dto.request;

import com.guianella.backend_textil.infraestructure.adapter.util.UnitSales;
import com.guianella.backend_textil.infraestructure.config.validation.ValueOfEnum;
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

    @NotNull(message = "La unidad no puede estar en blanco")
    @ValueOfEnum(enumClass = UnitSales.class, message = "Unidades invalidas")
    private String unitSales;

    @Valid
    private List<FabricRequest> fabrics = new ArrayList<>();

//    public UnitSales getUnitSalesEnum() {
//        return UnitSales.valueOf(unitSales);
//    }
}

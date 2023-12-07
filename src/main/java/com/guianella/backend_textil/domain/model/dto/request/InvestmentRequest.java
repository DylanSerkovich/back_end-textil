package com.guianella.backend_textil.domain.model.dto.request;

import com.guianella.backend_textil.domain.model.constant.CommonConstant;
import com.guianella.backend_textil.infraestructure.adapter.util.UnitSales;
import com.guianella.backend_textil.infraestructure.config.validation.ValueOfEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = CommonConstant.NOT_NULL_MESSAGE_ERROR)
    @ValueOfEnum(enumClass = UnitSales.class, message = "Unidades invalidas")
    private String unitSales;

    @Valid
    private List<FabricRequest> fabrics = new ArrayList<>();

}

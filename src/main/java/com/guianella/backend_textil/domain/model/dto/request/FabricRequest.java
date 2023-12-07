package com.guianella.backend_textil.domain.model.dto.request;

import com.guianella.backend_textil.domain.model.constant.CommonConstant;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = CommonConstant.NOT_NULL_MESSAGE_ERROR)
    @Positive(message = CommonConstant.NOT_NEGATIVE_MESSAGE_ERROR)
    @Digits(integer = 8, fraction = 2)
    private BigDecimal size;

    @NotNull(message = CommonConstant.NOT_NULL_MESSAGE_ERROR)
    @Positive(message = CommonConstant.NOT_NEGATIVE_MESSAGE_ERROR)
    @Digits(integer = 3, fraction = 2, message = CommonConstant.DIGIT_OUT_OF_RANGE_MESSAGE)
    private BigDecimal yield;

    @NotNull(message = CommonConstant.NOT_NULL_MESSAGE_ERROR)
    @Positive(message = CommonConstant.NOT_NEGATIVE_MESSAGE_ERROR)
    @Digits(integer = 8, fraction = 2, message = CommonConstant.DIGIT_OUT_OF_RANGE_MESSAGE)
    private BigDecimal sizeCost;

}

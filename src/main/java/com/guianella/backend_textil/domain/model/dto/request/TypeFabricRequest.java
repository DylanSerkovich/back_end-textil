package com.guianella.backend_textil.domain.model.dto.request;

import com.guianella.backend_textil.domain.model.constant.CommonConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeFabricRequest {
    @NotBlank(message = CommonConstant.NOT_NULL_MESSAGE_ERROR)
    private String typeName;
}

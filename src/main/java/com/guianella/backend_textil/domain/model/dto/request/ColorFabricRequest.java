package com.guianella.backend_textil.domain.model.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ColorFabricRequest {
    @Pattern(regexp = "^[a-zA-Z ]{3,}$", message = "El color debe ser un nombre válido")
    private String name;
    @Pattern(regexp = "^$|^([0-9a-fA-F]{6}|[0-9a-fA-F]{3})$", message = "El color debe ser una cadena vacía o un código de color hexadecimal")
    private String hexadecimal;
}

package com.guianella.backend_textil.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ColorFabric {
    private Long id;
    private String nameColor;
    private String hexadecimal;
}

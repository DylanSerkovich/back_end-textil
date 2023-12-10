package com.guianella.backend_textil.application.usecases;

import com.guianella.backend_textil.domain.model.dto.ColorFabricDto;
import com.guianella.backend_textil.domain.model.dto.request.ColorFabricRequest;

import java.util.List;

public interface ColorFabricService {
    ColorFabricDto createNew(ColorFabricRequest request);
    List<ColorFabricDto> getAll();
}

package com.guianella.backend_textil.application.service;

import com.guianella.backend_textil.application.mapper.ColorFabricDtoMapper;
import com.guianella.backend_textil.application.mapper.ColorFabricRequestMapper;
import com.guianella.backend_textil.application.usecases.ColorFabricService;
import com.guianella.backend_textil.domain.model.dto.ColorFabricDto;
import com.guianella.backend_textil.domain.model.dto.request.ColorFabricRequest;
import com.guianella.backend_textil.domain.port.ColorFabricPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorFabricManagementService implements ColorFabricService {
    private final ColorFabricPersistencePort colorFabricPersistencePort;

    public ColorFabricManagementService(final ColorFabricPersistencePort colorFabricPersistencePort) {
        this.colorFabricPersistencePort = colorFabricPersistencePort;
    }

    @Override
    public ColorFabricDto createNew(ColorFabricRequest request) {
        var colorToCreate = ColorFabricRequestMapper.toDomain(request);
        var colorCreated = colorFabricPersistencePort.create(colorToCreate);
        return ColorFabricDtoMapper.toDto(colorCreated);
    }

    @Override
    public List<ColorFabricDto> getAll() {
        return colorFabricPersistencePort.getAll()
                .stream()
                .map(ColorFabricDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}

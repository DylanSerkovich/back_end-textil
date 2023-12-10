package com.guianella.backend_textil.application.service;

import com.guianella.backend_textil.application.mapper.TypeFabricDtoMapper;
import com.guianella.backend_textil.application.mapper.TypeFabricRequestMapper;
import com.guianella.backend_textil.application.usecases.TypeFabricService;
import com.guianella.backend_textil.domain.model.dto.TypeFabricDto;
import com.guianella.backend_textil.domain.model.dto.request.TypeFabricRequest;
import com.guianella.backend_textil.domain.port.TypeFabricPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeFabricManagementService implements TypeFabricService {

    private final TypeFabricPersistencePort typeFabricPersistencePort;

    public TypeFabricManagementService(final TypeFabricPersistencePort typeFabricPersistencePort) {
        this.typeFabricPersistencePort = typeFabricPersistencePort;
    }

    @Override
    public TypeFabricDto createNew(TypeFabricRequest request) {
        var typeToCreate = TypeFabricRequestMapper.toDomain(request);
        var typeCreated = typeFabricPersistencePort.create(typeToCreate);
        return TypeFabricDtoMapper.toDto(typeCreated);
    }

    @Override
    public List<TypeFabricDto> getAll() {
        return typeFabricPersistencePort.getAll()
                .stream()
                .map(TypeFabricDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TypeFabricDto update(TypeFabricRequest request, long id) {
        var typeToUpdate = TypeFabricRequestMapper.toDomain(request);
        typeToUpdate.setId(id);
        typeToUpdate.setTypeName(request.getTypeName());
        return TypeFabricDtoMapper.toDto(typeFabricPersistencePort.update(typeToUpdate));
    }
}

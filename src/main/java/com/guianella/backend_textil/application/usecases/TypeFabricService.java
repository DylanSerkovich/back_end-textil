package com.guianella.backend_textil.application.usecases;

import com.guianella.backend_textil.domain.model.dto.TypeFabricDto;
import com.guianella.backend_textil.domain.model.dto.request.TypeFabricRequest;

import java.util.List;

public interface TypeFabricService {
    TypeFabricDto createNew(TypeFabricRequest request);
    List<TypeFabricDto> getAll();
    TypeFabricDto update(TypeFabricRequest request,long id);

}

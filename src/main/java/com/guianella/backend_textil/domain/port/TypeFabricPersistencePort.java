package com.guianella.backend_textil.domain.port;

import com.guianella.backend_textil.domain.model.TypeFabric;

public interface TypeFabricPersistencePort {

    TypeFabric getById(Long id);

}

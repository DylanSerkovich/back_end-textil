package com.guianella.backend_textil.domain.port;

import com.guianella.backend_textil.domain.model.ColorFabric;

public interface ColorFabricPersistencePort {

    ColorFabric getById(Long id);
}

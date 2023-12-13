package com.guianella.backend_textil.domain.port;

import com.guianella.backend_textil.domain.model.TypeFabric;

import java.util.List;

public interface TypeFabricPersistencePort {
    TypeFabric create(TypeFabric typeFabric);
    TypeFabric getById(Long id);
    List<TypeFabric> getAll();
    TypeFabric update(TypeFabric typeFabric);
    void deleteById(Long id);

}

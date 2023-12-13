package com.guianella.backend_textil.domain.port;

import com.guianella.backend_textil.domain.model.ColorFabric;

import java.util.List;

public interface ColorFabricPersistencePort {
    ColorFabric create(ColorFabric request);
    ColorFabric getById(Long id);
    List<ColorFabric> getAll();
    ColorFabric update(ColorFabric colorFabric);
    void deleteById(Long id);

}

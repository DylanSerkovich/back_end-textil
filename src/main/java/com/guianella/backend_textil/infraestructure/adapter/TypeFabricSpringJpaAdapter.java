package com.guianella.backend_textil.infraestructure.adapter;

import com.guianella.backend_textil.domain.model.TypeFabric;
import com.guianella.backend_textil.domain.port.TypeFabricPersistencePort;
import com.guianella.backend_textil.infraestructure.adapter.mapper.TypeFabricDboMapper;
import com.guianella.backend_textil.infraestructure.adapter.repository.TypeFabricRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TypeFabricSpringJpaAdapter implements TypeFabricPersistencePort {

    private final TypeFabricRepository typeFabricRepository;

    public TypeFabricSpringJpaAdapter(TypeFabricRepository typeFabricRepository) {
        this.typeFabricRepository = typeFabricRepository;
    }

    @Override
    public TypeFabric getById(Long id) {
        var optionalTypeFabric = typeFabricRepository.findById(id);
        return TypeFabricDboMapper.toDomain(optionalTypeFabric.get());
    }
}

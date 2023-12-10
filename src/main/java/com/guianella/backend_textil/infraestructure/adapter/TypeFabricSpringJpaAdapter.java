package com.guianella.backend_textil.infraestructure.adapter;

import com.guianella.backend_textil.domain.model.TypeFabric;
import com.guianella.backend_textil.domain.model.constant.TypeFabricConstant;
import com.guianella.backend_textil.domain.port.TypeFabricPersistencePort;
import com.guianella.backend_textil.infraestructure.adapter.mapper.TypeFabricDboMapper;
import com.guianella.backend_textil.infraestructure.adapter.repository.TypeFabricRepository;
import com.guianella.backend_textil.infraestructure.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TypeFabricSpringJpaAdapter implements TypeFabricPersistencePort {

    private final TypeFabricRepository typeFabricRepository;

    public TypeFabricSpringJpaAdapter(TypeFabricRepository typeFabricRepository) {
        this.typeFabricRepository = typeFabricRepository;
    }

    @Override
    public TypeFabric create(TypeFabric request) {
        var typeToSave = TypeFabricDboMapper.toDbo(request);
        var typeSaved= typeFabricRepository.save(typeToSave);
        return TypeFabricDboMapper.toDomain(typeSaved);
    }

    @Override
    public TypeFabric getById(Long id) {
        var optionalTypeFabric = typeFabricRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(
                        "Not Found Type Fabric",
                        String.format(TypeFabricConstant.NOT_FOUNT_MESSAGE_DEVELOP,id),
                        TypeFabricConstant.NOT_FOUNT_MESSAGE_USER
                ));
        return TypeFabricDboMapper.toDomain(optionalTypeFabric);
    }

    @Override
    public List<TypeFabric> getAll() {
        return typeFabricRepository.findAll()
                .stream()
                .map(TypeFabricDboMapper::toDomain)
                .collect(Collectors.toList());
    }
}

package com.guianella.backend_textil.infraestructure.adapter;

import com.guianella.backend_textil.domain.model.TypeFabric;
import com.guianella.backend_textil.domain.model.constant.TypeFabricConstant;
import com.guianella.backend_textil.domain.port.TypeFabricPersistencePort;
import com.guianella.backend_textil.infraestructure.adapter.entity.TypeFabricEntity;
import com.guianella.backend_textil.infraestructure.adapter.mapper.TypeFabricDboMapper;
import com.guianella.backend_textil.infraestructure.adapter.repository.TypeFabricRepository;
import com.guianella.backend_textil.infraestructure.exception.GenericClientException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
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
                ()-> new GenericClientException(
                        HttpStatus.NOT_FOUND,
                        "Type Fabric Not Found",
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

    @Override
    public TypeFabric update(TypeFabric typeFabric) {
        var typeToUpdate = TypeFabricDboMapper.toDbo(typeFabric);
        return TypeFabricDboMapper.toDomain(typeFabricRepository.save(typeToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        var entity = typeFabricRepository.findById(id).orElse(new TypeFabricEntity());
        if (!entity.getFabrics().isEmpty()){
            throw new GenericClientException(
                   HttpStatus.BAD_REQUEST,
                    "Type Fabric No Allow to Delete",
                    String.format(TypeFabricConstant.CURRENT_NOT_ALLOW_TO_DELETE_DEVELOP,id),
                    TypeFabricConstant.CURRENT_NOT_ALLOW_TO_DELETE_DEVELOP

            );
        }
        typeFabricRepository.deleteById(id);
    }
}

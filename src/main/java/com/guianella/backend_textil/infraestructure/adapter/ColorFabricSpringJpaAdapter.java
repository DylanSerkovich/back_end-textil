package com.guianella.backend_textil.infraestructure.adapter;

import com.guianella.backend_textil.domain.model.ColorFabric;
import com.guianella.backend_textil.domain.model.constant.ColorFabricConstant;
import com.guianella.backend_textil.domain.port.ColorFabricPersistencePort;
import com.guianella.backend_textil.infraestructure.adapter.entity.ColorFabricEntity;
import com.guianella.backend_textil.infraestructure.adapter.mapper.ColorDboMapper;
import com.guianella.backend_textil.infraestructure.adapter.repository.ColorFabricRepository;
import com.guianella.backend_textil.infraestructure.exception.GenericClientException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ColorFabricSpringJpaAdapter implements ColorFabricPersistencePort {

    private final ColorFabricRepository colorFabricRepository;

    public ColorFabricSpringJpaAdapter(ColorFabricRepository colorFabricRepository) {
        this.colorFabricRepository = colorFabricRepository;
    }

    @Override
    public ColorFabric create(ColorFabric request) {
        var colorToSave = ColorDboMapper.toDbo(request);
        var colorSaved = colorFabricRepository.save(colorToSave);

        return ColorDboMapper.toDomain(colorSaved);
    }

    @Override
    public ColorFabric getById(Long id) {
        var optionalColor = colorFabricRepository.findById(id).orElseThrow(
                ()-> new GenericClientException(
                        HttpStatus.NOT_FOUND,
                        "Not Found Color Fabric",
                        String.format(ColorFabricConstant.NOT_FOUNT_MESSAGE_DEVELOP,id),
                        ColorFabricConstant.NOT_FOUNT_MESSAGE_USER)
            );
        return ColorDboMapper.toDomain(optionalColor);
    }

    @Override
    public List<ColorFabric> getAll() {
        return colorFabricRepository.findAll()
                .stream()
                .map(ColorDboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public ColorFabric update(ColorFabric colorFabric) {
        var colorToUpdate = ColorDboMapper.toDbo(colorFabric);
        return ColorDboMapper.toDomain(colorFabricRepository.save(colorToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        var entity = colorFabricRepository.findById(id).orElse(new ColorFabricEntity());
        if(!entity.getFabrics().isEmpty()){
            throw new GenericClientException(
                    HttpStatus.BAD_REQUEST,
                    "Color Fabric No Allow to Delete",
                    String.format(ColorFabricConstant.CURRENT_NOT_ALLOW_TO_DELETE_DEVELOP,id),
                    ColorFabricConstant.CURRENT_NOT_ALLOW_TO_DELETE_USER

            );
        }
        colorFabricRepository.deleteById(id);
    }

}

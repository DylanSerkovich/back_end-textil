package com.guianella.backend_textil.infraestructure.adapter;

import com.guianella.backend_textil.domain.model.ColorFabric;
import com.guianella.backend_textil.domain.model.constant.ColorFabricConstant;
import com.guianella.backend_textil.domain.port.ColorFabricPersistencePort;
import com.guianella.backend_textil.infraestructure.adapter.mapper.ColorDboMapper;
import com.guianella.backend_textil.infraestructure.adapter.repository.ColorFabricRepository;
import com.guianella.backend_textil.infraestructure.exception.NotFoundException;
import jakarta.transaction.Transactional;
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
                ()-> new NotFoundException(
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

}

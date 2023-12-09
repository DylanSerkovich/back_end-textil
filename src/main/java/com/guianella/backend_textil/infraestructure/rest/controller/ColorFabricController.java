package com.guianella.backend_textil.infraestructure.rest.controller;

import com.guianella.backend_textil.application.usecases.ColorFabricService;
import com.guianella.backend_textil.domain.model.dto.ColorFabricDto;
import com.guianella.backend_textil.domain.model.dto.request.ColorFabricRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/color-fabric")
public class ColorFabricController {

    private final ColorFabricService colorFabricService;

    public ColorFabricController(ColorFabricService colorFabricService) {
        this.colorFabricService = colorFabricService;
    }

    @PostMapping
    public ResponseEntity<ColorFabricDto> create(@RequestBody @Validated ColorFabricRequest colorFabricRequest){
        return new ResponseEntity<>(colorFabricService.createNew(colorFabricRequest), HttpStatus.CREATED);
    }
}

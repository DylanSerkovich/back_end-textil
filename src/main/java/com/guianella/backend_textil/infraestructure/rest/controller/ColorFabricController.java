package com.guianella.backend_textil.infraestructure.rest.controller;

import com.guianella.backend_textil.application.usecases.ColorFabricService;
import com.guianella.backend_textil.domain.model.dto.ColorFabricDto;
import com.guianella.backend_textil.domain.model.dto.ListDto;
import com.guianella.backend_textil.domain.model.dto.request.ColorFabricRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<ListDto> getAll(){
        List<ColorFabricDto> dto = colorFabricService.getAll();
        return new ResponseEntity<>(new ListDto(HttpStatus.OK.value(),dto.size(),dto),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColorFabricDto> update(@RequestBody @Validated ColorFabricRequest colorFabricRequest,
                                                 @PathVariable Long id){
        return new ResponseEntity<>( colorFabricService.update(colorFabricRequest,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        colorFabricService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

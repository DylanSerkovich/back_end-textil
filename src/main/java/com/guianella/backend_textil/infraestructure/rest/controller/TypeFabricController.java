package com.guianella.backend_textil.infraestructure.rest.controller;

import com.guianella.backend_textil.application.usecases.TypeFabricService;
import com.guianella.backend_textil.domain.model.dto.ListDto;
import com.guianella.backend_textil.domain.model.dto.TypeFabricDto;
import com.guianella.backend_textil.domain.model.dto.request.TypeFabricRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/type-fabric")
public class TypeFabricController {
    private final TypeFabricService typeFabricService;

    public TypeFabricController(TypeFabricService typeFabricService) {
        this.typeFabricService = typeFabricService;
    }

    @PostMapping
    public ResponseEntity<TypeFabricDto> create(@RequestBody @Validated TypeFabricRequest typeFabricRequest){
        return new ResponseEntity<>(typeFabricService.createNew(typeFabricRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ListDto> getAll(){
        List<TypeFabricDto> dto = typeFabricService.getAll();
        return new ResponseEntity<>(new ListDto(HttpStatus.OK.value(),dto.size(),dto),HttpStatus.OK);
    }
}

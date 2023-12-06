package com.guianella.backend_textil.infraestructure.adapter.repository;

import com.guianella.backend_textil.infraestructure.adapter.entity.ColorFabricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorFabricRepository extends JpaRepository<ColorFabricEntity, Long> {
}
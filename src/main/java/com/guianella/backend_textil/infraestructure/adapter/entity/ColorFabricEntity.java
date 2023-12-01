package com.guianella.backend_textil.infraestructure.adapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "color_fabric")
public class ColorFabricEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_color_fabric", nullable = false)
    private Long id;

    @Column(name = "name_color", nullable = false, length = 20)
    private String nameColor;

    @Column(name = "hexadecimal", nullable = false, length = 6)
    private String hexadecimal;

    @OneToMany(mappedBy = "idColorFabric", fetch = FetchType.LAZY)
    private List<FabricEntity> fabrics = new ArrayList<>();
}
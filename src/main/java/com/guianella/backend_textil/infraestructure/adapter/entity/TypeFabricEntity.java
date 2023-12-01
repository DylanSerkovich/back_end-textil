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
@Table(name = "type_fabric")
public class TypeFabricEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_fabric", nullable = false)
    private Long id;

    @Column(name = "type_name", nullable = false, length = 50)
    private String typeName;

    @OneToMany(mappedBy = "idTypeFabric", fetch = FetchType.LAZY)
    private List<FabricEntity> fabrics = new ArrayList<>();

}
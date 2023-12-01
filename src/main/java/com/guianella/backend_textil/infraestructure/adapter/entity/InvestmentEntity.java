package com.guianella.backend_textil.infraestructure.adapter.entity;

import com.guianella.backend_textil.infraestructure.adapter.util.UnitSales;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "investment")
public class InvestmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investment", nullable = false)
    private Long id;

    @Column(name = "investor_name", nullable = false, length = 100)
    private String investorName;

    @Column(name = "complete_date")
    private Instant completeDate;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_sales", nullable = false)
    private UnitSales unitSales;

    @OneToMany(mappedBy = "idInvestment", cascade = CascadeType.PERSIST)
    private List<FabricEntity> fabrics = new ArrayList<>();

    @OneToMany(mappedBy = "idInvestment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<GarmentEntity> garments = new ArrayList<>();

    @OneToOne(mappedBy = "idInvestment")
    private ManufactureEntity manufacture;

}
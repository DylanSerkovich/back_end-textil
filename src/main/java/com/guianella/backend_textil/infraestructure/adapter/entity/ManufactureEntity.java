package com.guianella.backend_textil.infraestructure.adapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "manufacture")
public class ManufactureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manufacture", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_investment", nullable = false)
    private InvestmentEntity idInvestment;

    @Column(name = "cost_per_garment", nullable = false, precision = 6, scale = 2)
    private BigDecimal costPerGarment;

    @Column(name = "cost_perbutton", nullable = false, precision = 6, scale = 2)
    private BigDecimal costPerbutton;

    @Column(name = "service_button", nullable = false, precision = 6, scale = 2)
    private BigDecimal serviceButton;

    @Column(name = "service_cuttape", nullable = false, precision = 6, scale = 2)
    private BigDecimal serviceCuttape;

}
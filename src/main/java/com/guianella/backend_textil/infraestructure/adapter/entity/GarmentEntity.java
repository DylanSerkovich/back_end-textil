package com.guianella.backend_textil.infraestructure.adapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "garment")
public class GarmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_garment", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_investment", nullable = false)
    private InvestmentEntity idInvestment;

    @Column(name = "name_garment", nullable = false, length = 20)
    private String nameGarment;

    @Column(name = "price_garment", nullable = false, precision = 5, scale = 2)
    private BigDecimal priceGarment;

    @Column(name = "lot", columnDefinition = "int UNSIGNED not null")
    private Long lot;

    @Column(name = "sub_total", precision = 10, scale = 2)
    private BigDecimal subTotal;

}
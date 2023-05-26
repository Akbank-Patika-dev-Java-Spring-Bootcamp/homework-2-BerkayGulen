package com.berkaygulen.akbankbootcamphw2.entity;

import com.berkaygulen.akbankbootcamphw2.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Product", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Product",sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "PRODUCT_NAME",length = 50, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "DESCRIPTION",length = 300, nullable = false)
    @NotBlank
    private String description;

    @Column(name = "PRICE",nullable = false)
    private double price;

    @Column(name = "QUANTITY",nullable = false)
    private int quantity;

    // double ve int değerlere @NotBlank anotasyonu verince patladı


}

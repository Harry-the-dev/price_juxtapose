package com.cintech.PriceJuxtapose.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence",sequenceName = "product_sequence",allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @Column(name = "prod_id", nullable = false)
    private Long id;

    @Column(name = "prod_volume", nullable = false)
    private Double prodVolume;

    @Column(name = "prod_volume_unit", length = 2)
    private String prodVolumeUnit;

    @Column(name = "title", nullable = false)
    private String prodTitle;



}
package com.cintech.PriceJuxtapose.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pick_n_pay")
public class PickNPay {


    @MapsId
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prod_id")
    private Product product;

    @Id
    @Column(name = "prod_id", nullable = false)
    private Long id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url", nullable = false)
    private String url;

}
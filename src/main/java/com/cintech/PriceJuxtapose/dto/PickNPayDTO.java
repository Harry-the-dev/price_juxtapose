package com.cintech.PriceJuxtapose.dto;

import lombok.*;

import javax.persistence.Column;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickNPayDTO {

    private Long id ;
    private Double price;
    private String title;
    private String url;
    private ProductDTO productDTO;

}

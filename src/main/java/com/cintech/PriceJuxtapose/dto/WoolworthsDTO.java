package com.cintech.PriceJuxtapose.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WoolworthsDTO {

    private Long id ;
    private Double price;
    private String title;
    private String url;
    private ProductDTO productDTO;
}

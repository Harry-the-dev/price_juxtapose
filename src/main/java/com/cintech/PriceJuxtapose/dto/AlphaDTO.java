package com.cintech.PriceJuxtapose.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlphaDTO {
    private ProductDTO productDTO;
    private PickNPayDTO pickNPayDTO;
    private WoolworthsDTO woolworthsDTO;
}

package com.cintech.PriceJuxtapose.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String prodTitle;
    private Double prodVolume;
    private String prodVolumeUnit;


}

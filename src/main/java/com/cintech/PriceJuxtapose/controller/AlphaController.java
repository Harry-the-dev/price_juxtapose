package com.cintech.PriceJuxtapose.controller;

import com.cintech.PriceJuxtapose.dto.AlphaDTO;
import com.cintech.PriceJuxtapose.dto.PickNPayDTO;
import com.cintech.PriceJuxtapose.service.AlphaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alpha")
public class AlphaController {

    private AlphaService alphaService;

    public AlphaController(AlphaService alphaService) {
        this.alphaService = alphaService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addBulk")
    public boolean addWoolworthsProducts(@RequestBody List<AlphaDTO> alphaDTO) {
        alphaDTO.forEach(value -> alphaService.saveBulk(value));
        return true;
    }

    @GetMapping("/getAllBulk")
    public List<AlphaDTO> getPickNPayProducts() {
        return alphaService.getAllBulk();
    }




}

package com.cintech.PriceJuxtapose.controller;


import com.cintech.PriceJuxtapose.dto.ProductDTO;
import com.cintech.PriceJuxtapose.entity.Product;
import com.cintech.PriceJuxtapose.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    private final ProductService productService ;

    public productController(ProductService productService) {
        this.productService = productService;
    }

    // GET all products
    //-----------------------------------------------------------------------------
    @GetMapping("/getAllProducts")
    public List<Product> returnAllProducts()
    {
        return productService.getAll();
    }







}

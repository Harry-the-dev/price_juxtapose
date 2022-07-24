package com.cintech.PriceJuxtapose.controller;


import com.cintech.PriceJuxtapose.dto.PickNPayDTO;
import com.cintech.PriceJuxtapose.service.PickNPayService;
import com.cintech.PriceJuxtapose.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class PickNPayController {


    private final ProductService productService ;
    private final PickNPayService pickNPayService ;

    public PickNPayController(ProductService productService, PickNPayService pickNPayService) {
        this.productService = productService;
        this.pickNPayService = pickNPayService;
    }

    //http://localhost:8080/test/getPickNPayProducts
    //-----------------------------GET all PNP products------------------------------------------------
    @GetMapping("/getPickNPayProducts")
    public List<PickNPayDTO> getPickNPayProducts() {
        return pickNPayService.getALL();
    }

    //http://localhost:8080/test/getPickNPayProductById
    //-----------------------------GET all PNP products By ID------------------------------------------------
    @GetMapping("/getPickNPayProductsByTitle/{id}")
    public PickNPayDTO getALLPickNPayProductById(@PathVariable Long id) {
        return pickNPayService.getProductById(id);
    }

    //http://localhost:8080/test/getPickNPayProductsByTitle
    //-----------------------------GET all PNP products By Title------------------------------------------------
    @GetMapping("/getProductByTitle/{title}")
    public List<PickNPayDTO> getPickNPayProductsByTitle(@PathVariable String title) {
        return pickNPayService.getProductsByTitleContaining(title);
    }

    //http://localhost:8080/test/getPickNPayProductsByPriceBetween
    // GET all PNP products By Price Between
    //-----------------------------------------------------------------------------
    @GetMapping("/getPickNPayProductsByPriceBetween/{min}/{max}")
    public List<PickNPayDTO> getProductsByPriceBetween(@PathVariable double min , @PathVariable double max ) {
        return pickNPayService.getProductsByPriceBetween(min,max);
    }


    //http://localhost:8080/test/addPickNPayProduct
    // ADD PNP product
    //-----------------------------------------------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addPickNPayProduct")
    public boolean addPickNPayProduct ( @RequestBody PickNPayDTO pickNPay)
    {
        pickNPayService.saveProduct(pickNPay);
        return true ;
    }

    //http://localhost:8080/test/addPickNPayProducts
    // ADD PNP products
    //-----------------------------------------------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addPickNPayProducts")
    public boolean addPickNPayProducts ( @RequestBody List<PickNPayDTO> pickNPay)
    {
        pickNPay.forEach(value -> pickNPayService.saveProduct(value));
        return true ;
    }


}
